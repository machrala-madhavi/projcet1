package com.test1.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test1.model.Customer;
import com.test1.model.SignUp;
import com.test1.model.SignUp1;
import com.test1.model.Vw_Xmap_ps;
import com.test1.service.CustomerService;
import com.test1.service.SignUpService;
import com.test1.service.VmPsService;

@Controller
public class UserController {
	
	@Autowired
	private VmPsService vwpsservice;
	@Autowired
	private SignUpService signupservice;
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/reqDisplayProductsUser")
	public String displayProductsUser(Model m,HttpSession hsession){
		//List<Vw_Xmap_ps>psdata=vwpsservice.getVwPs();
		List<Vw_Xmap_ps>psdata=vwpsservice.getBestVwPs();
		m.addAttribute("username",hsession.getAttribute("loginusername"));
		m.addAttribute("userid", hsession.getAttribute("userimage"));
		m.addAttribute("psdata",psdata);
		m.addAttribute("cartsize",hsession.getAttribute("cartsize"));
		m.addAttribute("imagenum", CommonController.generateRandomNum());
		return "displayproductsuser";
		}
	@RequestMapping("/reqAllSuppProduct")
	public String displayAllSuppliers(@RequestParam("pid")String pid,Model m,HttpSession hsession){
	List<Vw_Xmap_ps>data=vwpsservice.getAllSuppProducts(pid);
	m.addAttribute("prid",data.get(0).getProductid());
	m.addAttribute("productname", data.get(0).getProductname());
	m.addAttribute("supplier", data);
	m.addAttribute("imagenum", CommonController.generateRandomNum());
	m.addAttribute("username",hsession.getAttribute("loginusername"));
	m.addAttribute("userid",hsession.getAttribute("userimage"));
	m.addAttribute("cartsize",hsession.getAttribute("cartsize"));
	return "allSuppProduct";
	}
	
	@RequestMapping("/reqEditProfilePage")
	public String displayEditUserPage(HttpSession hsession,Model m,Principal principal){
		SignUp1 su=signupservice.getUserById(hsession.getAttribute("userimage").toString());
	     Customer cust=customerService.getCustomerByUserId(su.getUserid());
	     //SignUp1 su1=signupservice.getUserById(principal.getName());
	    m.addAttribute("username",hsession.getAttribute("loginusername"));
		m.addAttribute("userid",hsession.getAttribute("userimage"));
//		m.addAttribute("loginuserid", hsession.getAttribute("loginuserid"));
		m.addAttribute("cartsize",hsession.getAttribute("cartsize"));
		m.addAttribute("userObject", su);
		return "editProfilePage";
	}
	@RequestMapping("/reqEditProfileToDb")
	public String editProfileToDb(@ModelAttribute("userObject")SignUp1 su, HttpSession hsession){		
		signupservice.editUser(su);
		
		Customer cust = customerService.getCustomerByUserId(su.getUserid());
		
		hsession.setAttribute("loginusername", cust.getCustname());
//		hsession.setAttribute("userlogedin", su.getUsername());
		return "redirect:/reqDisplayProductsUser";
	}
	
}
