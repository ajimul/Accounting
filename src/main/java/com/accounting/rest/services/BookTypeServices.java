package com.accounting.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accounting.rest.entity.BookType;
import com.accounting.rest.exception.BooksTypeNotFoundException;
import com.accounting.rest.repository.BookTypeRepo;

@Service
public class BookTypeServices {

	private final BookTypeRepo bookTypeRepo;

	@Autowired
	public BookTypeServices(BookTypeRepo bookTypeRepo) {
		this.bookTypeRepo = bookTypeRepo;
	}

	@PostConstruct
	public void PreeAccountsList() {
		ArrayList<String> preeBookTypes = new ArrayList<String>();
		preeBookTypes.add("Purchase Book");
		preeBookTypes.add("Purchase Return Book");
		preeBookTypes.add("Sales Book");
		preeBookTypes.add("Sales Return Book");
		preeBookTypes.add("Cash Book");
		preeBookTypes.add("Bills Receivable Book");
		preeBookTypes.add("Bills Payable Book");
		preeBookTypes.add("Journal Proper");
		preeBookTypes.add("Amc Service Book");

		List<BookType> bookTypeList = new ArrayList<BookType>();
		for (int i = 0; i < preeBookTypes.size(); i++) {
			Optional<BookType> optionalAcType = Optional.ofNullable(new BookType());
			optionalAcType = getBookTypeByName(preeBookTypes.get(i));
			if (!optionalAcType.isPresent()) {
				BookType bookType = new BookType();
				bookType.setBookTypeName(preeBookTypes.get(i));
				bookTypeList.add(bookType);
			}

		}

		if (bookTypeList.size() != 0) {
			bookTypeRepo.saveAll(bookTypeList);
		}

	}

	public Optional<BookType> getBookTypeByName(String typeName) {
		BookType ac = new BookType();
		ac = bookTypeRepo.getBookByName(typeName);
		Optional<BookType> opt = Optional.ofNullable(ac);
		return opt;

	}

//Add BookType

	public BookType addBookType(BookType bookType) {
		return bookTypeRepo.save(bookType);

	}

//Find All BookType 
//	public List<GenericsBookType> findAllBookType() {
//		List<GenericsBookType> bookTytpe = new ArrayList<GenericsBookType>();
//		List<BookType> bookTypeList = bookTypeRepo.findAll();
//		for (BookType bookTypes : bookTypeList) {
//			GenericsBookType newBook = new GenericsBookType();
//			newBook.setBookTypeId(bookTypes.getBookTypeId());
//			newBook.setBookTypeName(bookTypes.getBookTypeName());
//			bookTytpe.add(newBook);
//		}
//		return bookTytpe;
//	}

	// Find Accounts By Name
	public BookType getBookTypeId(String typeName) {
		return bookTypeRepo.getBookByName(typeName);

	}

//Find BookType By Id
	public BookType findBookTypeById(Long id) {
		return bookTypeRepo.findById(id).orElseThrow(() -> new BooksTypeNotFoundException(""));

	}

//Update BookType

//Delete BookType By Id
	public void deleteBookTypeById(Long id) {

		bookTypeRepo.deleteById(id);

	}

}
