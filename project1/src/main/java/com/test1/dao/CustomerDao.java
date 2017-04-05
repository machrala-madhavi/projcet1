package com.test1.dao;

import com.test1.model.Customer;

public interface CustomerDao {
	public abstract String addCustomer(Customer cust);
	public abstract Customer getCustomerByUserId(String userid);

}
