package com.test1.service;

import com.test1.model.Cart;

public interface CartService {

	public abstract  Cart getCart(String cartid); 
	public abstract int getCartSize(Cart cart);
	public abstract void updateCart(Cart cart);
}
