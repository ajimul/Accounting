package com.accounting.rest.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence_generator")
	@SequenceGenerator(name = "sequence_generator", sequenceName = "SequenceGenerator_user", allocationSize = 1)

	private Long userId;
	private String userName;
	private String password;
	private Boolean active;
	private String clientId;
	private String dbName;
	private String roles;

	@OneToMany(targetEntity = Ledger.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "ledgerUser_Ref", referencedColumnName = "userId")
	private List<Ledger> ledger;

	@OneToMany(targetEntity = BookInfo.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "bookInfoUser_Ref", referencedColumnName = "userId")
	private List<BookInfo> bookInfos;

	@OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "ps_AuthorId", referencedColumnName = "userId")
	private List<Product> productOfServices;

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(Long userId, String userName, String password, boolean active, String clientId, String dbName,
			String roles, List<Ledger> ledger, List<BookInfo> bookInfos, List<Product> productOfServices) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.active = active;
		this.clientId = clientId;
		this.dbName = dbName;
		this.roles = roles;
		this.ledger = ledger;
		this.bookInfos = bookInfos;
		this.productOfServices = productOfServices;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public List<Ledger> getLedger() {
		return ledger;
	}

	public void setLedger(List<Ledger> ledger) {
		this.ledger = ledger;
	}

	public List<BookInfo> getBookInfos() {
		return bookInfos;
	}

	public void setBookInfos(List<BookInfo> bookInfos) {
		this.bookInfos = bookInfos;
	}

	public List<Product> getProductOfServices() {
		return productOfServices;
	}

	public void setProductOfServices(List<Product> productOfServices) {
		this.productOfServices = productOfServices;
	}

}
