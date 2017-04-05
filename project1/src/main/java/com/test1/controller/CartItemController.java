package com.test1.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test1.model.Cart;
import com.test1.model.CartItem;
import com.test1.model.Customer;
import com.test1.model.Vw_Xmap_ps;
import com.test1.model.Xmap_product_Supplier;
import com.test1.service.CartItemService;
import com.test1.service.CartService;
import com.test1.service.CustomerService;
import com.test1.service.VmPsService;
import com.test1.service.XmapPsService;

@Controller
public class CartItemController {

	@Autowired
	private CartItemService cartItemService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private XmapPsService xmapService;
	@Autowired
	private CartService cartService;	
	@Autowired
	private VmPsService vmpsservice;
	
	@RequestMapping("/reqAddItemToCart/{psid}")
	public String addItemToCart(@PathVariable("psid")String psid, @RequestParam("qty")int qty,Principal principal,HttpSession hsession,Model model){
		System.out.println("psid : "+psid + "  qty : " + qty);
		
		/*Authentication authentication = principal.
		UserDetails1 user= (UserDetails1)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
*/
		String userid=principal.getName();
		System.out.println(userid);
		//Customer customer=customerService.getCustomerByUserId(userid);
		//Cart cart=customer.getCart();
		Customer customer1=customerService.getCustomerByUserId(userid);
		Cart cart=customer1.getCart();
		
		Xmap_product_Supplier xmapProduct = xmapService.getXmap_product_SupplierById(psid);
		
		CartItem cartitem = new CartItem();			
		cartitem.setCart(cart);
		cartitem.setXmap_product_supplier(xmapProduct); 
		cartitem.setQuantity(qty);
		cartitem.setItemwisetotal(xmapProduct.getProductsupplierprice()*qty);
		
		cartItemService.addCartItem(cartitem);
		
		Customer cust=customerService.getCustomerByUserId(userid);
		Cart cart1= cust.getCart();
		
		
		List<CartItem> cartitems = cart1.getCartItems();
		int sum=0;
		for(CartItem critem :cartitems)
			sum+= critem.getItemwisetotal();
		
		cart1.setGrandtotal(sum);
		cartService.updateCart(cart1);
		int cartsize1 = cartService.getCartSize(cart);
		
		List<Vw_Xmap_ps> psdata = vmpsservice.getBestVwPs();
		
		model.addAttribute("psdata", psdata);
		model.addAttribute("imagenum", CommonController.generateRandomNum());
	//	model.addAttribute("loginusername",hsession.getAttribute("loginusername"));
		//model.addAttribute("loginuserid",hsession.getAttribute("loginuserid"));
		model.addAttribute("userid", hsession.getAttribute("userimage"));
		model.addAttribute("cartsize", cartsize1);
		model.addAttribute("cartmessage","Item added to cart successfully");
		
		hsession.setAttribute("cartsize", cartsize1);
		model.addAttribute("username",hsession.getAttribute("loginusername"));
		model.addAttribute("userid", hsession.getAttribute("userimage"));
		
		System.out.println("cart size :" + cartsize1);
		

		
		return "displayproductsuser";
		
		//return "redirect:/reqDisplayProductsUser";
	}
	
	@RequestMapping("/reqDisplayCart")
	public String displayCart(HttpSession hsession,Model m){
		
		Customer cust = customerService.getCustomerByUserId(hsession.getAttribute("userimage").toString());
		Cart cart = cust.getCart();
		
		int cartsize=cartService.getCartSize(cart);
		hsession.setAttribute("cartsize", cartsize);
		
		List<CartItem> cartItems=cart.getCartItems();
		int sum=0;
		for(CartItem critem:cartItems){
			sum+=critem.getItemwisetotal();
		}
		
		cart.setGrandtotal(sum);
		cartService.updateCart(cart);
		
		
		m.addAttribute("loginusername", hsession.getAttribute("loginusername"));
		m.addAttribute("loginuserid", hsession.getAttribute("loginuserid"));
		m.addAttribute("cartsize",hsession.getAttribute("cartsize"));
		m.addAttribute("grandtotal",cart.getGrandtotal());
		m.addAttribute("cartItems", cartItems);
		m.addAttribute("customerid",cust.getCustomerid());
		m.addAttribute("customer" ,cust);
		return "displayCartItems";
	}
	
	@RequestMapping("/reqDeleteCartItem/{cartitemid}")
	public String deleteCartItem(@PathVariable("cartitemid")String cartitemid,Principal principal){
		cartItemService.removeCartItem(cartitemid);
		return "redirect:/reqDisplayCart";
	
	}
	
	@RequestMapping("/reqClearCart/{customerid}")
	public String deletAllCartItems(@PathVariable("customerid")String customerid,HttpSession hsession){
		cartItemService.removeAllCartItems(customerid);
		hsession.setAttribute("cartsize", 0);
		return"redirect:/reqDisplayProductsUser";
	}
	
	
}

	
