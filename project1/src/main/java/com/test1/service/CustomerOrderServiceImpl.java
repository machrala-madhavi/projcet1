package com.test1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test1.dao.CustomerOrderDao;
import com.test1.model.CustomerOrder;
import com.test1.model.ProductReview;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

	@Autowired
	private CustomerOrderDao customerOrderDao;
	
	public List<CustomerOrder> custOrders(String custid) {
		return customerOrderDao.custOrders(custid);
	}
	public void addProductReview(ProductReview pr) {
		customerOrderDao.addProductReview(pr);		
	}

}
