package com.accounting.rest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.accounting.rest.dto.FolioDTO;
import com.accounting.rest.entity.FolioNumber;

public interface FolioNumberRepo extends JpaRepository<FolioNumber, Long> {
	@Query("SELECT new com.accounting.rest.dto.FolioDTO(fo.folioId,fo.folioNarration,bi.bookInfoAccount_Ref,bi.bookInfoDate,bd.bookDetailsId,bd.bookDetailsBookInfo_Ref,bd.bookDetailsInventoryItems_Ref,bd.bookDetailsParticularAmount,bd.bookDetailsUnit,bd.bookDetailsUnitValue,bd.bookDetailsMolelNo,bd.bookDetailsTradDiscount,bd.bookDetailsTradDiscountAmount,bd.bookDetailsCgst,bd.bookDetailsSgst,bd.bookDetailsIgst,bd.bookDetailsCgstAmount,bd.bookDetailsSgstAmount,bd.bookDetailsIgstAmount,emi.emiId,emi.emi_BiId,emi.emiNo,emi.emiAmount,emi.emiStatus,emi.emiDate,emi.emiMessage,emi.emiSmsStatus)"
			+ "FROM  FolioNumber fo " + "join fo.bookInfos bi " + "join bi.bookDetails bd " + "join bi.emi emi ")
	List<FolioDTO> getEmi();

	@Query("select f from FolioNumber f where f.folioId = :folioId")
	Optional<FolioNumber> findById(@Param("folioId") Long folioId);

//	@Query("SELECT new com.accounting.rest.dto.Party_BookInfo_BookDetails_BookDetailsSNo_DTO" + "(" + "f.folioId,"
//			+ "f.folioNarration," + "bi.bookInfoId," + "bi.bookInfoType_Ref," + "bi.bookInfoFolio_Ref,"
//			+ "bi.bookInfoUser_Ref," + "bi.bookInfoAccount_Ref," + "bi.bookInfoNarration," + "bi.invoiceNo,"
//			+ "bi.invoiceDate," + "bi.bookInfoDate," + "bd.bookDetailsId," + "bd.bookDetailsBookInfo_Ref,"
//			+ "bd.bookDetailsInventoryItems_Ref," + "bd.bookDetailsParticularAmount," + "bd.bookDetailsUnit,"
//			+ "bd.bookDetailsUnitValue," + "bd.bookDetailsMolelNo," + "bd.bookDetailsTradDiscount,"
//			+ "bd.bookDetailsTradDiscountAmount," + "bd.bookDetailsCgst," + "bd.bookDetailsSgst,"
//			+ "bd.bookDetailsIgst," + "bd.bookDetailsCgstAmount," + "bd.bookDetailsSgstAmount,"
//			+ "bd.bookDetailsIgstAmount," + "sn.sId," + "sn.bd_Id,"
//			+ "sn.serialNo)FROM  FolioNumber f join f.bookInfos bi join bi.bookDetails bd join bd.bookItemsSerialNo sn where f.folioId like:folioId")
//	List<Party_BookInfo_BookDetails_BookDetailsSNo_DTO> getFolio_BookInfo_BookDetails_ItemsSerialNo(
//			@Param("folioId") Long folioId);

}
