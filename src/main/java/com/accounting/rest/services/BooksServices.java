package com.accounting.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accounting.rest.entity.Books;
import com.accounting.rest.exception.BooksNotFoundException;
import com.accounting.rest.repository.BooksRepo;

@Service
@Transactional() // Use For Single Database
//@Transactional("tenantTransactionManager")//Use For Multitenant
public class BooksServices {

	private final BooksRepo booksRepo;

	@Autowired
	public BooksServices(BooksRepo booksRepo) {
		this.booksRepo = booksRepo;
	}

// add Books
	public Books addBooks(Books books) {
		return booksRepo.save(books);

	}

// add List Of Books
	public List<Books> addBooks(List<Books> books) {
		return booksRepo.saveAll(books);

	}

//Find All Books 
	public List<Books> findAllBooks() {
		return booksRepo.findAll();

	}

//Find Books By Id
	public Books findBooksById(Long id) {
		return booksRepo.findById(id).orElseThrow(() -> new BooksNotFoundException(""));

	}

	public List<Books> findBooksByVoucherIdf(Long id) {
		return booksRepo.findBooksByVoucherId(id);

	}

//Update Books 

//Delete Books By Id
	public void deleteBooksBybooksId(Long id) {

		booksRepo.deleteById(id);

	}

}
