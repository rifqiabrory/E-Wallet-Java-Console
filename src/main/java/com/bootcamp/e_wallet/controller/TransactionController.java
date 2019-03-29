package com.bootcamp.e_wallet.controller;

import com.bootcamp.e_wallet.config.Connect;
import com.bootcamp.e_wallet.dbUtill.TransactionDbUtill;
import com.bootcamp.e_wallet.model.TransactionEntity;
import com.bootcamp.e_wallet.repository.TransactionRepository;

public class TransactionController implements TransactionRepository{

	private TransactionDbUtill transactionDbUtill;
	
	public TransactionController() {
		transactionDbUtill = new TransactionDbUtill(Connect.getConnection());
	}

	public void addTransactionTopUp(TransactionEntity topUp) {
		transactionDbUtill.addTransactionTopUp(topUp);
		
	}

}
