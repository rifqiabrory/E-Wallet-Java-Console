package com.bootcamp.e_wallet.model;

import java.util.Date;

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
 * ForeignKey ke TransactionTypeEntity(PrimeryKey)
 * dengan ERD @ManyToOne @JoinColumn
*/


@Entity(name="Transaction")
@Table(name="tbl_transaction")
public class TransactionEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_transaction")
	private int idTransaction;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="an_debit")
	private int anDebit;
	
	@Column(name="an_credit")
	private int anCredit;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="transaction_type")
	private int transactionType;

	public int getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(int idTransaction) {
		this.idTransaction = idTransaction;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getAnDebit() {
		return anDebit;
	}

	public void setAnDebit(int anDebit) {
		this.anDebit = anDebit;
	}

	public int getAnCredit() {
		return anCredit;
	}

	public void setAnCredit(int anCredit) {
		this.anCredit = anCredit;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(int transactionType) {
		this.transactionType = transactionType;
	}
	
}
