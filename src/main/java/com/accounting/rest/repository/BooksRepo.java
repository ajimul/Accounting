package com.accounting.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.accounting.rest.entity.Books;

public interface BooksRepo extends JpaRepository<Books, Long> {
	@Query("select u from Books u where u.booksInfo_Ref=:voucherId")
	List<Books> findBooksByVoucherId(@Param("voucherId") Long voucherId);

}
