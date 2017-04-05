package com.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test1.dao.CartItemDao;
import com.test1.model.Cart;
import com.test1.model.CartItem;

@Service
public class CarItemServiceImpl implements CartItemService {

	@Autowired
	private CartItemDao cartitemdao;
	
	public void addCartItem(CartItem cartItem) {
		cartitemdao.addCartItem(cartItem);
	}

	public CartItem getCartItems(String cartItemId) {
		return cartitemdao.getCartItems(cartItemId);
	}

	public void removeCartItem(String cartItemId) {
		cartitemdao.removeCartItem(cartItemId);

	}

	public void removeAllCartItems(String customerid) {
		cartitemdao.removeAllCartItems(customerid);
	}
 
}
