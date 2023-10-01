package com.accounting.rest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.accounting.rest.entity.BookInfo;

public interface BookInfoRepo extends JpaRepository<BookInfo, Long> {
	@Query("select u from BookInfo u where u.bookInfoType_Ref=:bookInfoType_Ref")
	List<BookInfo> GetBookByBookTypeId(@Param("bookInfoType_Ref") Long bookInfoType_Ref);

	@Query(value = "SELECT BookInfo.bookInfoDate,bd.bookDetailsParticular,accounts.accountName,accounts.accountId, Emi.emiAmount FROM BookInfo as bookinfo,Accounts as accounts,BookDetails as bd,Emi as emi  where bookinfo.bookInfoAccount_Ref=accounts.accountId and bookinfo.bookInfoId=bd.bookDetailsBookInfo_Ref and bookinfo.bookInfoId=emi.emi_BiId and accounts.accountId=20", nativeQuery = true)
	List<Object> getEmi();

	Optional<BookInfo> findByBookInfoId(Long id);

}
