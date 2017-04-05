package com.test1.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test1.model.BillingAddress;
import com.test1.model.Cart;
import com.test1.model.Customer;
import com.test1.model.ShippingAddress;
import com.test1.model.SignUp;
import com.test1.model.SignUp1;
import com.test1.model.Vw_Xmap_ps;
import com.test1.service.CartItemService;
import com.test1.service.CustomerService;
import com.test1.service.SignUpService;
import com.test1.service.VmPsService;

@Controller
public class HomeController {
	
@Autowired
private SignUpService signupservice;

@Autowired
private CustomerService customerservice;
@Autowired
private CartItemService cartItemService;

@Autowired
private VmPsService vwpsservice;

@RequestMapping("/")
public String displayhomepage(Model model){
	List<Vw_Xmap_ps>psdata=vwpsservice.getBestVwPs();
	model.addAttribute("userObj", new SignUp());
	model.addAttribute("userObj1", new SignUp());
	
	Customer cust = new Customer();			
	ShippingAddress shippingAddress = new ShippingAddress();		
	SignUp1 signUp1 = new SignUp1();
	
	cust.setSignUp1(signUp1);
	cust.setShippingAddress(shippingAddress);		
	
	model.addAttribute("customerObject", cust);
	model.addAttribute("psdata", psdata);
	
	model.addAttribute("imagenum", CommonController.generateRandomNum());
		return "index";
}


@RequestMapping("/home")
public String displayhomepage1( Model model){
	model.addAttribute("userObj", new SignUp());
	model.addAttribute("userObj1", new SignUp());
	
	Customer cust = new Customer();			
	ShippingAddress shippingAddress = new ShippingAddress();		
	SignUp1 signUp1 = new SignUp1();
	
	cust.setSignUp1(signUp1);
	cust.setShippingAddress(shippingAddress);		
	
	model.addAttribute("customerObject", cust);
	List<Vw_Xmap_ps> psdata=vwpsservice.getBestVwPs();
	model.addAttribute("psdata", psdata);
	model.addAttribute("imagenum", CommonController.generateRandomNum());
 return "index";
}


   @RequestMapping("/reqForsigninpage")
public String displayloginpage(@RequestParam(value="error",required=false)String error,
		   @RequestParam(value="logout",required=false)String logout,Model m,HttpSession hses){
	   if(error!=null)
		   m.addAttribute("error", "invalid userid and password... please enter valid details");
	   if(logout!=null){
		   m.addAttribute("logout","you have logged out successfully.thank you");
		   return "index";
	   }
	   //m.addAttribute("userObj",new SignUp());
	   return "signinpage";
   }
   
   @RequestMapping("/reqForSignupPage")
   public String displaysignuppage(Model m,HttpSession hses){
	   
	   SignUp temp=new SignUp();
	   m.addAttribute("userObj", temp);
	   return "signuppage";
   }
   
   @RequestMapping("/reqSingupDatatoDB")
   public String addUser(@ModelAttribute("userObj1")SignUp su,Model m){
	   System.out.println("controller");
    String uid=	signupservice.addUser(su);
//    m.addAttribute("message","1");
    m.addAttribute("message","Signup is successful.New userid:"+uid);
    SignUp temp=new SignUp();
    m.addAttribute("userObj1", temp);
    m.addAttribute("userObj",  new SignUp());
	m.addAttribute("imagenum", CommonController.generateRandomNum());
        return "signinpage";
   }
   
  /* @RequestMapping("/reqLoginCheck")
    public String authenticate(@ModelAttribute("userObj")SignUp su,Model m,HttpSession hsession){
	   
	   SignUp1 result=signupservice.loginCheck(su);
	   if(result==null){
		m.addAttribute("message","login failed.....retry");
		m.addAttribute("userObj", new SignUp());
		m.addAttribute("userObj1", new SignUp());
		m.addAttribute("imagenum", CommonController.generateRandomNum());
		return "index";
		//	return "signinpage";
	   }
	   else{//login success
		   Customer cust = customerservice.getCustomerByUserId(result.getUserid().toString());
		   if(result.getRole().equals("ROLE_ADMIN")){
			   
			   hsession.setAttribute("loginusername", cust.getCustname());
			hsession.setAttribute("userlogin",result.getUserid() );
			m.addAttribute("loginusername", cust.getCustname());
			m.addAttribute("userimage", result.getUserid());
			//hsession.setAttribute("userlogedin", result.getUsername());
			//m.addAttribute("username", result.getUsername());
			m.addAttribute("imagenum", CommonController.generateRandomNum());
			//return "loginsuccessadmin";
			   m.addAttribute("user",su);
			   return"signinsucessadmin";
		   }
		    else{
			 //  m.addAttribute("user",su);
			   m.addAttribute("imagenum", CommonController.generateRandomNum());
			   hsession.setAttribute("loginusername", cust.getCustname());
			   hsession.setAttribute("userlogin",result.getUserid() );
			   m.addAttribute("loginusername", cust.getCustname());
			   m.addAttribute("userimage", result.getUserid());
				//m.addAttribute("userlogedin", result.getUsername());
				//hsession.setAttribute("userlogedin", result.getUsername());
				//m.addAttribute("imagenum", CommonController.generateRandomNum());
				 m.addAttribute("user",su);
			   return "signinsuccessuser";
	   }
	   
   }   

}*/
@RequestMapping("/reqLogout")
public String logout(HttpSession hsession){
	hsession.setAttribute("loginusername", null);
	hsession.setAttribute("userlogin", null);
	return "redirect:/home";
}

// spring security

@RequestMapping("/reqspringloginpage")
public String displaySpringLoginPage(@RequestParam(value="error",required=false)String error,
		   @RequestParam(value="logout",required=false)String logout,Model m,HttpSession hses){
	   if(error!=null)
		   m.addAttribute("error", "invalid userid and password... please enter valid details");
	   if(logout!=null){
		   m.addAttribute("logout","you have logged out successfully.thank you");
		   return "index";
	   }
	   //m.addAttribute("userObj",new SignUp());
	   	return"springloginpage";
}

@RequestMapping("/logout")
public String displaySpringLogout(){
	return"springloginpage";
}
@RequestMapping("/loginCheck1")
public String loginCheck(Principal principal,Model m,HttpSession hsession){
	System.out.print("\n HomeController - logincheck()");
	System.out.print("\n Name:"+ principal.getName());
	Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
	String userrole=authentication.getAuthorities().toString().substring(1,10);
	System.out.print("\n Role:"+userrole);
	//SignUp su= signupservice.getUserById(principal.getName());
	
	SignUp1 su = (SignUp1)signupservice.getUserById(principal.getName());
	Customer cust = customerservice.getCustomerByUserId(su.getUserid());
	
	/*m.addAttribute("loginusername",cust.getCustname());
	m.addAttribute("userimage", su.getUserid());
	m.addAttribute("cartsize",cust.getCart().getCartItems().size());
	m.addAttribute("imagenum", CommonController.generateRandomNum());
	
//	hsession.setAttribute("userlogedin",su.getUsername());
	hsession.setAttribute("loginusername",cust.getCustname());
	hsession.setAttribute("userimage", su.getUserid());
	hsession.setAttribute("cartsize", cust.getCart().getCartItems().size());
	*/
	
	if(userrole.equals("ROLE_ADMI")){
		m.addAttribute("madhavi","hello this is madhavi");
		m.addAttribute("imagenum",CommonController.generateRandomNum());
	//	m.addAttribute("username",su.getUsername());
		//m.addAttribute("userlogin",su.getUserid());
		//m.addAttribute("username",hsession.getAttribute("loginusername"));
		hsession.setAttribute("userimage", su.getUserid());
		m.addAttribute("userid", hsession.getAttribute("userimage"));
		
		
		return"signinsucessadmin";
	}
	else if(userrole.equals("ROLE_USER")){
		m.addAttribute("imagenum",CommonController.generateRandomNum());
	//	m.addAttribute("username",su.getUsername());
		//m.addAttribute("userimage",su.getUserid());
		hsession.setAttribute("loginusername",cust.getCustname());
		m.addAttribute("username",hsession.getAttribute("loginusername"));
		hsession.setAttribute("userimage", su.getUserid());
		hsession.setAttribute("cartsize", cust.getCart().getCartItems().size());
		m.addAttribute("cartsize",cust.getCart().getCartItems().size());
		
		m.addAttribute("userid", hsession.getAttribute("userimage"));
		return"signinsuccessuser";
	}
	else
		return null;
}

@RequestMapping("/reqDisplayUsers")
public String displayUsers(Model m,HttpSession hsession){		
	List<SignUp1> userdata = signupservice.getSignUp();
	m.addAttribute("userdata", userdata);
	m.addAttribute("userid", hsession.getAttribute("userimage"));
	m.addAttribute("imagenum", CommonController.generateRandomNum());
	return "displayusers";
}

@RequestMapping("reqDisableUser")
public String disableUser(@RequestParam("uid")String uid){
	signupservice.disableUser(uid);
	return "redirect:/reqDisplayUsers";
}

@RequestMapping("reqEnableUser")
public String enableUser(@RequestParam("uid")String uid){
	signupservice.enableUser(uid);
	return "redirect:/reqDisplayUsers";
}



@RequestMapping("/reqSendSignupDataToDB")
public String addUserToDb( @ModelAttribute("customerObject")Customer customer, Model m){
	
	BillingAddress ba = new BillingAddress();
	ba.setHouseno(customer.getShippingAddress().getHouseno());
	ba.setStreet(customer.getShippingAddress().getStreet());
	ba.setArea(customer.getShippingAddress().getArea());
	ba.setCity(customer.getShippingAddress().getCity());
	ba.setState(customer.getShippingAddress().getState());
	ba.setCountry(customer.getShippingAddress().getCountry());
	ba.setPincode(customer.getShippingAddress().getPincode());
	customer.setBillingAddress(ba);
	customer.setCart(new Cart());
	String custid = customerservice.addCustomer(customer);
	
	/*String cid = userdetailsservice.addUser(su);*/
	m.addAttribute("message", "1");
	m.addAttribute("message1", "Signup is successfull. Your login id : " + custid);
	SignUp temp=new SignUp();
	m.addAttribute("userObject1",  temp);
	m.addAttribute("userObject",  new SignUp());
	Customer cust = new Customer();			
	ShippingAddress shippingAddress = new ShippingAddress();		
	SignUp1 signUp1 = new SignUp1();
	
	cust.setSignUp1(signUp1);
	cust.setShippingAddress(shippingAddress);		
	
	m.addAttribute("customerObject", cust);	
	
	m.addAttribute("imagenum", CommonController.generateRandomNum());
	
	return "springloginpage";
}

}

