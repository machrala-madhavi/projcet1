package com.test1.dao;

import java.util.List;

import com.test1.model.Cart;
import com.test1.model.CustomerOrder;
import com.test1.model.ProductReview;

public interface CustomerOrderDao {

		public void addCustomerOrder(Cart cart);
		
		public List<CustomerOrder> custOrders(String custid);
		public void addProductReview(ProductReview pr);
}
