package com.bootcamp.e_wallet.controller;

import java.util.List;

import com.bootcamp.e_wallet.config.Connect;
import com.bootcamp.e_wallet.dbUtill.AccountDbUtill;
import com.bootcamp.e_wallet.model.AccountEntity;
import com.bootcamp.e_wallet.repository.AccountRepository;

public class AccountController implements AccountRepository{

	private AccountDbUtill accountDbUtill;

	public AccountController() {
		accountDbUtill = new AccountDbUtill(Connect.getConnection());
	}
	public List<AccountEntity> getAllAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addAccount(AccountEntity account) {
		accountDbUtill.addAccount(account);
	}

}
