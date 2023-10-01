package com.accounting.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accounting.rest.entity.BookDetails;
import com.accounting.rest.services.BookDetailsServices;

@RestController
@RequestMapping("api/bookdetails")
public class BookDetailsController {
	private final BookDetailsServices bookDetailsServices;

	@Autowired
	public BookDetailsController(BookDetailsServices bookDetailsServices) {
		super();
		this.bookDetailsServices = bookDetailsServices;
	}

	@GetMapping("/{refId}")
	public ResponseEntity<List<BookDetails>> getBookDetailsByRef_Id(@PathVariable("refId") Long refId) {
		return new ResponseEntity<>(bookDetailsServices.findByBookDetailsByBookInfoId(refId), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<BookDetails>> getBookDetails() {
		return new ResponseEntity<>(bookDetailsServices.findBookDetails(), HttpStatus.OK);
	}

//	@GetMapping("/invoice/{folioId}")
//	public ResponseEntity<FolioNumber> getFolio_BookInfo_BookDetails_ItemsSerialNo(
//			@PathVariable("folioId") Long folioId) {
//		return new ResponseEntity<>(folioNumberServices.findFolioNumberById(folioId), HttpStatus.OK);
//	}

	@PostMapping("/add")
	public ResponseEntity<List<BookDetails>> addBookDetails(@RequestBody List<BookDetails> bd) {
		return new ResponseEntity<>(bookDetailsServices.addBookDetails(bd), HttpStatus.OK);
	}

}
