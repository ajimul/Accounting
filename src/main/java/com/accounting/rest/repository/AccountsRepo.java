
package com.accounting.rest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.accounting.rest.dto.EmiListDTO;
import com.accounting.rest.dto.EmiSmsConfig;
import com.accounting.rest.dto.EmployeeDetailsDTO;
import com.accounting.rest.dto.InvoiceDataDTO;
import com.accounting.rest.dto.PartyBookInfoDto;
import com.accounting.rest.dto.PartyDetailsDTO;
import com.accounting.rest.dto.ProductServiceSmsConfig;
import com.accounting.rest.entity.Accounts;

public interface AccountsRepo extends JpaRepository<Accounts, Long> {

	@Modifying
	@Query("UPDATE Accounts p SET p.accountName =?1 WHERE p.accountId = ?2")
	int UpdateAccount(String accountName, Long accountId);

	// this code only for work transaction related query
	@Query("select u from Accounts u where u.accountName = :accountName")
	Accounts getAccountIdByAccountName(@Param("accountName") String accountName);

	// this code only for work transaction related query
	@Query("select u from Accounts u where u.accountId = :accountId")
	Accounts getAccountNameById(@Param("accountId") Long accountId);

	// this code only for work EMI entity
	@Query("SELECT new com.accounting.rest.dto.EmiListDTO(" + "ac. accountId,ac. accountName," + "party.partyDetailsId,"
			+ "party.party_ac_refId," + "party.partyContactNo1," + "party.partyContactNo2," + "party.partyEmailId,"
			+ "party.partyGstNo," + "party.partyBillingAddress," + "party.partyShipingAddress,"
			+ "party.partyOpeningBalance," + "party.partyAreaCode," + "party.partyDob," + "party.partyBloodGroup,"
			+ "party.partyAadharNo," + "party.partyPanNo," + "bi.bookInfoId," + "bi.bookInfoFolio_Ref,"
			+ "bi.bookInfoType_Ref," + "bi.bookInfoDate," + "emi.emiId,emi.emiNo," + "emi.emiAmount," + "emi.emiStatus,"
			+ "emi.emiDate," + "emi.emiMessage," + "emi.emiSmsStatus," + "emi.emi_BiId)FROM  " + "Accounts ac "
			+ "join ac.partyDetails party " + "join ac.bookInfos bi "
			+ "join bi.emi emi  Where bi.bookInfoId=emi.emi_BiId")
	List<EmiListDTO> getEmiList();

	// this code only use for check if account is exist? if to return the result
	// others wise false
	Optional<Accounts> findByAccountName(String accountName);

	// this code only work for party entity
	@Query("SELECT new com.accounting.rest.dto.PartyDetailsDTO(ac.accountId,ac.accountName,party.partyDetailsId,party.party_ac_refId,party.partyContactNo1,party.partyContactNo2,party.partyEmailId,party.partyGstNo,party.partyBillingAddress,party.partyShipingAddress,party.partyOpeningBalance,party.partyAreaCode,party.partyDob,party.partyBloodGroup,party.partyAadharNo,party.partyPanNo) FROM Accounts ac join ac.partyDetails party where ac.accountName like:accountName")
	PartyDetailsDTO getPartyDetailsByName(@Param("accountName") String accountName);

	// this code only work for party entity
	@Query("SELECT new com.accounting.rest.dto.PartyDetailsDTO(ac.accountId,ac.accountName,party.partyDetailsId,party.party_ac_refId,party.partyContactNo1,party.partyContactNo2,party.partyEmailId,party.partyGstNo,party.partyBillingAddress,party.partyShipingAddress,party.partyOpeningBalance,party.partyAreaCode,party.partyDob,party.partyBloodGroup,party.partyAadharNo,party.partyPanNo) FROM Accounts ac join ac.partyDetails party where ac.accountId like:accountId")
	PartyDetailsDTO getPartyDetailsById(@Param("accountId") Long accountId);

	// this code only work for party entity
	@Query("SELECT new com.accounting.rest.dto.PartyDetailsDTO(ac.accountId,ac.accountName,party.partyDetailsId,party.party_ac_refId,party.partyContactNo1,party.partyContactNo2,party.partyEmailId,party.partyGstNo,party.partyBillingAddress,party.partyShipingAddress,party.partyOpeningBalance,party.partyAreaCode,party.partyDob,party.partyBloodGroup,party.partyAadharNo,party.partyPanNo) FROM Accounts ac join ac.partyDetails party")
	List<PartyDetailsDTO> getPartyDetailsList();

	// this code only work for employee entity
	@Query("SELECT new com.accounting.rest.dto.EmployeeDetailsDTO(ac.accountId,ac.accountName,"
			+ "emp.empDetailsId,emp.emp_ac_refId,emp.empContactNo1,emp.empContactNo2,emp.empEmailId,emp.empGstNo,"
			+ "emp.empBillingAddress,emp.empShipingAddress,emp.empOpeningBalance,emp.empAreaCode,"
			+ "emp.empDob,emp.empBloodGroup,emp.empJobeDesignation,emp.empJoiningDate,"
			+ "emp.empSalaryPackage,emp.empAadharNo,emp.empPanNo)"
			+ "FROM Accounts ac join ac.employeeDetails emp where ac.accountName like:accountName")
	EmployeeDetailsDTO getEmployeeDetailsByName(@Param("accountName") String accountName);

	// this code only work for employee entity
	@Query("SELECT new com.accounting.rest.dto.EmployeeDetailsDTO(ac.accountId,ac.accountName,"
			+ "emp.empDetailsId,emp.emp_ac_refId,emp.empContactNo1,emp.empContactNo2,emp.empEmailId,emp.empGstNo,"
			+ "emp.empBillingAddress,emp.empShipingAddress,emp.empOpeningBalance,emp.empAreaCode,"
			+ "emp.empDob,emp.empBloodGroup,emp.empJobeDesignation,emp.empJoiningDate,"
			+ "emp.empSalaryPackage,emp.empAadharNo,emp.empPanNo)"
			+ "FROM Accounts ac join ac.employeeDetails emp where ac.accountId like:accountId")
	EmployeeDetailsDTO getEmployeeDetailsById(@Param("accountId") Long accountId);

	// this code only work for employee entity
	@Query("SELECT new com.accounting.rest.dto.EmployeeDetailsDTO(ac.accountId,ac.accountName,"
			+ "emp.empDetailsId,emp.emp_ac_refId,emp.empContactNo1,emp.empContactNo2,emp.empEmailId,emp.empGstNo,"
			+ "emp.empBillingAddress,emp.empShipingAddress,emp.empOpeningBalance,emp.empAreaCode,"
			+ "emp.empDob,emp.empBloodGroup,emp.empJobeDesignation,emp.empJoiningDate,"
			+ "emp.empSalaryPackage,emp.empAadharNo,emp.empPanNo)" + "FROM Accounts ac join ac.employeeDetails emp")
	List<EmployeeDetailsDTO> getEmployeeDetailsList();

	@Query("SELECT new com.accounting.rest.dto.EmiSmsConfig(" + "ac.accountId," + "ac.accountName," + "emi.emiId,"
			+ "emi.emiNo," + "emi.emiAmount," + "emi.emiStatus," + "emi.emiDate," + "emi.emiMessage,"
			+ "emi.emiSmsStatus," + "emi.emi_BiId)FROM  Accounts ac join ac.bookInfos bi join bi.emi emi")
	List<EmiSmsConfig> getSmsConfig();

	@Query("SELECT new com.accounting.rest.dto.ProductServiceSmsConfig(ac.accountId,ac.accountName,ps.psId,ps.ps_Id,ps.psEngineerName,ps.psNo,ps.psDate,ps.psStatus,ps.psMessage,ps.psSmsStatus)FROM  Accounts ac join ac.productOfServices s join s.productServices ps")
	List<ProductServiceSmsConfig> getServiceSmsConfig();

	@Query("SELECT new com.accounting.rest.dto.InvoiceDataDTO(ac.accountId,ac.accountName,p.partyContactNo1,p.partyContactNo2,p.partyEmailId,p.partyGstNo,p.partyBillingAddress,p.partyShipingAddress,bi.bookInfoId,bi.bookInfoNarration,bi.bookInfoDate,bi.bookInfoType_Ref,	bi.bookInfoFolio_Ref,	bi.bookInfoUser_Ref,	bi.bookInfoAccount_Ref,	bi.invoiceNo,	bi.invoiceDate,bd.bookDetailsId,bd.bookDetailsParticularAmount,bd.bookDetailsUnit,bd.bookDetailsUnitValue,bd.bookDetailsMolelNo,bd.bookDetailsTradDiscount,bd.bookDetailsTradDiscountAmount,bd.bookDetailsCgst,bd.bookDetailsSgst,bd.bookDetailsIgst,bd.bookDetailsCgstAmount,bd.bookDetailsSgstAmount,bd.bookDetailsIgstAmount)FROM  Accounts ac join ac.partyDetails p join ac.bookInfos bi join bi.bookDetails bd")
	List<InvoiceDataDTO> getInvoiceData();

	@Query("SELECT new com.accounting.rest.dto.PartyBookInfoDto(ac.accountId,ac.accountName,p.partyContactNo1,p.partyContactNo2,p.partyEmailId,p.partyGstNo,p.partyBillingAddress,p.partyShipingAddress,bi.bookInfoId,bi.bookInfoNarration,bi.bookInfoDate,bi.bookInfoType_Ref,	bi.bookInfoFolio_Ref,	bi.bookInfoUser_Ref,	bi.bookInfoAccount_Ref,	bi.invoiceNo,	bi.invoiceDate,bd.bookDetailsId,bd.bookDetailsBookInfo_Ref,bd.bookDetailsInventoryItems_Ref)FROM  Accounts ac join ac.partyDetails p join ac.bookInfos bi join bi.bookDetails bd")
	List<PartyBookInfoDto> getPartyBookInfo();

	@Query("SELECT new com.accounting.rest.dto.PartyBookInfoDto(ac.accountId,ac.accountName,p.partyContactNo1,p.partyContactNo2,p.partyEmailId,p.partyGstNo,p.partyBillingAddress,p.partyShipingAddress,bi.bookInfoId,bi.bookInfoNarration,bi.bookInfoDate,bi.bookInfoType_Ref,	bi.bookInfoFolio_Ref,	bi.bookInfoUser_Ref,	bi.bookInfoAccount_Ref,	bi.invoiceNo,	bi.invoiceDate,bd.bookDetailsId,bd.bookDetailsBookInfo_Ref,bd.bookDetailsInventoryItems_Ref)FROM  Accounts ac join ac.partyDetails p join ac.bookInfos bi join bi.bookDetails bd where ac.accountId like:accountId")
	List<PartyBookInfoDto> getPartyBookInfoByPartyId(@Param("accountId") Long accountId);

}
