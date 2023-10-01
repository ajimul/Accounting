package com.accounting.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.accounting.rest.dto.BooksDetailsDTO;
import com.accounting.rest.entity.InventoryItems;

public interface InventoryItemsRepo extends JpaRepository<InventoryItems, Long> {
	@Query("select u from inventory_items u where u.iiId=:Id")
	InventoryItems getInventoryItemsById(@Param("Id") Long Id);

	@Modifying
	@Query("UPDATE inventory_items i SET i.ii_ilId =?1,i.iiQty =?2,i.iiMrp =?3,i.iiPurchaseAmount =?4,i.iiSalesAmount =?5,"
			+ "i.iiTDPercent =?6,i.iiParticular =?7,i.iiHsn =?8,i.iiModelNo =?9,i.iiUnitName =?10,i.iiCgstPercent =?11,"
			+ "i.iiSgstPercent =?12,i.iiIgstPercent =?13,i.iiNoOfService =?14,i.iiMonthOfWarranty=?15 WHERE i.iiId = ?16")
	int UpdateInventoryItems(Long ii_ilId, Integer iiQty, Double iiMrp, Double iiPurchaseAmount, Double iiSalesAmount,
			Integer iiTDPercent, String iiParticular, String iiHsn, String iiModelNo, String iiUnitName,
			Integer iiCgstPercent, Integer iiSgstPercent, Integer iiIgstPercent, Integer iiNoOfService,
			Integer iiMonthOfWarranty, Long iiId);

	@Query("SELECT new com.accounting.rest.dto.BooksDetailsDTO(item.iiParticular,item.iiHsn,item.iiNoOfService,item.iiMonthOfWarranty,bd.bookDetailsId,bd.bookDetailsBookInfo_Ref,bd.bookDetailsInventoryItems_Ref,bd.bookDetailsParticularAmount,bd.bookDetailsUnit,bd.bookDetailsUnitValue,bd.bookDetailsMolelNo,bd.bookDetailsTradDiscount,bd.bookDetailsTradDiscountAmount,bd.bookDetailsCgst,bd.bookDetailsSgst,bd.bookDetailsIgst,bd.bookDetailsCgstAmount,bd.bookDetailsSgstAmount,bd.bookDetailsIgstAmount) FROM  inventory_items item join item.bookDetails bd where item.iiId=bd.bookDetailsInventoryItems_Ref")
	List<BooksDetailsDTO> getBooksDetails();

	@Query("SELECT new com.accounting.rest.dto.BooksDetailsDTO(item.iiParticular,item.iiHsn,item.iiNoOfService,item.iiMonthOfWarranty,bd.bookDetailsId,bd.bookDetailsBookInfo_Ref,bd.bookDetailsInventoryItems_Ref,bd.bookDetailsParticularAmount,bd.bookDetailsUnit,bd.bookDetailsUnitValue,bd.bookDetailsMolelNo,bd.bookDetailsTradDiscount,bd.bookDetailsTradDiscountAmount,bd.bookDetailsCgst,bd.bookDetailsSgst,bd.bookDetailsIgst,bd.bookDetailsCgstAmount,bd.bookDetailsSgstAmount,bd.bookDetailsIgstAmount) FROM  inventory_items item join item.bookDetails bd Where item.iiId like :ii_Id")
	List<BooksDetailsDTO> getInventoryItemsByiiId(@Param("ii_Id") Long ii_Id);

	@Query("SELECT new com.accounting.rest.dto.BooksDetailsDTO(item.iiParticular,item.iiHsn,item.iiNoOfService,item.iiMonthOfWarranty,bd.bookDetailsId,bd.bookDetailsBookInfo_Ref,bd.bookDetailsInventoryItems_Ref,bd.bookDetailsParticularAmount,bd.bookDetailsUnit,bd.bookDetailsUnitValue,bd.bookDetailsMolelNo,bd.bookDetailsTradDiscount,bd.bookDetailsTradDiscountAmount,bd.bookDetailsCgst,bd.bookDetailsSgst,bd.bookDetailsIgst,bd.bookDetailsCgstAmount,bd.bookDetailsSgstAmount,bd.bookDetailsIgstAmount) FROM  inventory_items item join item.bookDetails bd Where bd.bookDetailsBookInfo_Ref like :bookDetailsBookInfo_Ref")
	List<BooksDetailsDTO> getInventoryItemsByBookInfoId(@Param("bookDetailsBookInfo_Ref") Long bookDetailsBookInfo_Ref);

}
