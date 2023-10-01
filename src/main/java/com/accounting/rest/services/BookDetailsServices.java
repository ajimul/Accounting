package com.accounting.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accounting.rest.entity.BookDetails;
import com.accounting.rest.repository.BookDetailsRepo;

@Service
public class BookDetailsServices {

	private final BookDetailsRepo bookDetailsRepo;

	@Autowired
	public BookDetailsServices(BookDetailsRepo bookDetailsRepo) {
		this.bookDetailsRepo = bookDetailsRepo;
	}

//Add BookDetails
	public List<BookDetails> addBookDetails(List<BookDetails> bookDetails) {
		return bookDetailsRepo.saveAll(bookDetails);

	}

//Find BookDetails
	public List<BookDetails> findBookDetails() {
		return bookDetailsRepo.findAll();

	}

//Find BookDetails By BookInfoId
	public List<BookDetails> findByBookDetailsByBookInfoId(Long id) {
		return bookDetailsRepo.findByBookDetailsBookInfo_Ref(id);

	}

//Update BookDetails

//Delete BookDetails By Id
	public void deleteBookDetailsBybooksId(Long id) {

		bookDetailsRepo.deleteById(id);

	}

}
