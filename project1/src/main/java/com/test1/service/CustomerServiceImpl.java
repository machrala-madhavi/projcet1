package com.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test1.dao.CustomerDao;
import com.test1.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	
	@Autowired
	private CustomerDao customerDao;
	public String addCustomer(Customer cust) {
		return customerDao.addCustomer(cust);
	}

	public Customer getCustomerByUserId(String userid) {
		return customerDao.getCustomerByUserId(userid);
	}

}
