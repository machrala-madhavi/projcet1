package com.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test1.dao.CartDao;
import com.test1.model.Cart;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDao cartDao;
	public Cart getCart(String cartid) {
		return cartDao.getCart(cartid);
	}

	public int getCartSize(Cart cart) {
		return cartDao.getCartSize(cart);
	}

	public void updateCart(Cart cart) {
		cartDao.updateCart(cart);
	}

}
