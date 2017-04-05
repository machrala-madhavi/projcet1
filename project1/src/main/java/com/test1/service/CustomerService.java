package com.test1.service;

import com.test1.model.Customer;

public interface CustomerService {

	public abstract String addCustomer(Customer cust);
	public abstract Customer getCustomerByUserId(String userid);

}
