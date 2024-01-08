package com.accounting.rest.post.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accounting.rest.entity.BookType;
import com.accounting.rest.repository.BookTypeRepo;

@Service
@Transactional() // Use For Single Database
//@Transactional("tenantTransactionManager")//Use For Multitenant
public class PostBookType {
	@Autowired
	private BookTypeRepo bookTypeRepo;

	public void BookAccountsList() {
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
}
