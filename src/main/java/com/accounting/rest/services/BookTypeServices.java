package com.accounting.rest.services;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accounting.rest.entity.BookType;
import com.accounting.rest.exception.BooksTypeNotFoundException;
import com.accounting.rest.post.service.PostBookType;
import com.accounting.rest.repository.BookTypeRepo;

@Service
@Transactional() // Use For Single Database
//@Transactional("tenantTransactionManager")//Use For Multitenant
public class BookTypeServices {
	@Autowired
	private BookTypeRepo bookTypeRepo;

	@Autowired
	public PostBookType postBookType;

	@PostConstruct
	public void BookTypeList() {
		postBookType.BookAccountsList();
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
