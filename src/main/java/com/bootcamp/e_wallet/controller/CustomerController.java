package com.bootcamp.e_wallet.controller;

import java.util.ArrayList;
import java.util.List;

import com.bootcamp.e_wallet.config.Connect;
import com.bootcamp.e_wallet.dbUtill.CustomerDbUtill;
import com.bootcamp.e_wallet.model.CustomerEntity;
import com.bootcamp.e_wallet.repository.CustomerRepository;

public class CustomerController implements CustomerRepository{
	private CustomerDbUtill customerDbUtill;

	public CustomerController() {
		customerDbUtill = new CustomerDbUtill(Connect.getConnection());
	}
	
	public void addCustomer(CustomerEntity customer) {
		customerDbUtill.addCustomer(customer);
	}

	public List<CustomerEntity> getAllCustomer() {
		List<CustomerEntity> customer = new ArrayList<CustomerEntity>();
		try {
			customer = customerDbUtill.getAllCustomer();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}
	
	
}
