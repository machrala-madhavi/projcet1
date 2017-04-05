package com.test1.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test1.model.Customer;
import com.test1.model.CustomerOrder;
import com.test1.model.ProductReview;
import com.test1.service.CustomerOrderService;
import com.test1.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired	
	private CustomerService customerService;
	
	@Autowired
	private CustomerOrderService customerOrderService;
	
	
	@RequestMapping("/order/{cartId}")
	public String displayCheckOut(@PathVariable String cartId){
		System.out.println("\nCartid in checkout : " + cartId);
		return "redirect:/checkout?cartId="+cartId;
	}

	
	@RequestMapping("/reqDisplayOrderHistory")
	public String displayOrderHistory(@RequestParam("uid")String userid, Model m){
		Customer cust = customerService.getCustomerByUserId(userid);
		List<CustomerOrder>orders = customerOrderService.custOrders(cust.getCustomerid());
		System.out.print("\nOrders : " + orders);
		//System.out.print("\nOrderItems : " + orders.get(0).getCustomerOrdersHistory());
		//System.out.print("\nOrderItems : " + orders.get(1).getCustomerOrdersHistory());
		
		m.addAttribute("orders", orders);
		
		
		return "displayOrders";
	}
	
	@RequestMapping("/reqAddProductRating/{productid}")
	public String rateProduct(@PathVariable String productid, @RequestParam("rating") int rating,HttpSession hsession){
		ProductReview prev = new ProductReview();
		prev.setCustomerid(customerService.getCustomerByUserId(hsession.getAttribute("userid").toString()).getCustomerid());
		prev.setCustomerorderhistoryid("na");
		prev.setRating(rating);
		prev.setProductid(productid);
		prev.setComments("ok");
		customerOrderService.addProductReview(prev);
		return null;
	}
	
}
