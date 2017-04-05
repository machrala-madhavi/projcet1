package com.test1.service;

import com.test1.model.Cart;
import com.test1.model.CartItem;

public interface CartItemService {

	public abstract void addCartItem(CartItem cartItem);
	public abstract CartItem getCartItems(String cartItemId);
	public abstract void removeCartItem(String cartItemId);
	public abstract void removeAllCartItems(String customerid);
}
