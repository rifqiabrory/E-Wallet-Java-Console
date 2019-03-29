package com.bootcamp.e_wallet.repository;

import com.bootcamp.e_wallet.model.TransactionEntity;

public interface TransactionRepository {
	void addTransactionTopUp(TransactionEntity topUp);
}
