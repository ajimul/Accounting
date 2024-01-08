package com.accounting.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accounting.rest.entity.BookInfo;
import com.accounting.rest.exception.BookInfoNotFoundException;
import com.accounting.rest.repository.BookInfoRepo;

@Service
@Transactional() // Use For Single Database
//@Transactional("tenantTransactionManager")//Use For Multitenant
public class BooksInfoServices {

	private final BookInfoRepo bookInfoRepo;

	@Autowired
	public BooksInfoServices(BookInfoRepo bookInfoRepo) {
		this.bookInfoRepo = bookInfoRepo;
	}

//Add Books
	public BookInfo addBookInfo(BookInfo bookInfo) {
		return bookInfoRepo.save(bookInfo);

	}

//Find All BookInfo 
	public List<BookInfo> findAllBookInfo() {
		return bookInfoRepo.findAll();

	}

//Find BookInfo By Id
	public BookInfo findBookInfoById(Long id) {
		return bookInfoRepo.findById(id).orElseThrow(() -> new BookInfoNotFoundException(""));

	}

//Update BookInfo

//Delete BookInfo By Id
	public void deleteBookInfoBybooksId(Long id) {

		bookInfoRepo.deleteById(id);

	}

}
