package com.bootcamp.e_wallet.repository;

import java.util.List;

import com.bootcamp.e_wallet.model.CustomerEntity;

public interface CustomerRepository {
	List<CustomerEntity> getAllCustomer();
	void addCustomer(CustomerEntity customer);
	
}
