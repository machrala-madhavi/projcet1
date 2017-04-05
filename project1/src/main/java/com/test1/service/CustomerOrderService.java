package com.test1.service;

import java.util.List;

import com.test1.model.CustomerOrder;
import com.test1.model.ProductReview;

public interface CustomerOrderService{

	public List<CustomerOrder> custOrders(String custid);
	public void addProductReview(ProductReview pr);
}
