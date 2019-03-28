package com.bootcamp.e_wallet.repository;

import java.util.List;

import com.bootcamp.e_wallet.model.AccountEntity;

public interface AccountRepository {
	List<AccountEntity> getAllAccount();
	void addAccount(AccountEntity account);
}
