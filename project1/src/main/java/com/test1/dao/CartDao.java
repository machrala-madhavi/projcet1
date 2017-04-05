package com.test1.dao;

import com.test1.model.Cart;

public interface CartDao {
	public abstract Cart getCart(String cartid);
	public abstract int getCartSize(Cart cart);
	public abstract void updateCart(Cart cart);
	
}
