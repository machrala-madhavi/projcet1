package com.test1.dao;

import com.test1.model.Cart;
import com.test1.model.CartItem;

public interface CartItemDao {

	public abstract void addCartItem(CartItem cartItem);
	public abstract CartItem getCartItems(String cartItemId);
	public abstract void removeCartItem(String cartItem);
	public abstract void removeAllCartItems(String customerid);
	public abstract void removeAllCartItems1(Cart cart);
}
