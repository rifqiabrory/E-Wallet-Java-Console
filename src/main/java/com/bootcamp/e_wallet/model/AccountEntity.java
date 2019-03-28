package com.bootcamp.e_wallet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/* Relasi Database,
 * Entity ini yang Mengirim 
 * ForeignKey ke CustomerEntity(PrimeryKey)
 * dengan ERD @ManyToOne @JoinColumn
*/

@Entity(name="Account")
@Table(name="tbl_account")
public class AccountEntity {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="account_number")
	private int accountNumber;
	
	@Column(name="account_name")
	private String accountName;
	
	@Column(name="open_date")
	private String openDate;
	
	@Column(name="balance")
	private int balance;
	
//	@Column(name="customer_number")
//	private int customerNumber;
	
	@ManyToOne
	@JoinColumn(name="customer_number")
	private CustomerEntity customer;

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getOpenDate() {
		return openDate;
	}

	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

//	public int getCustomerNumber() {
//		return customerNumber;
//	}
//
//	public void setCustomerNumber(int customerNumber) {
//		this.customerNumber = customerNumber;
//	}
	
}
