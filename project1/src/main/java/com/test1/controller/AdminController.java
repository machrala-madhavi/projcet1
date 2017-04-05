package com.test1.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test1.model.Product;
import com.test1.service.ProductService;

@Controller
public class AdminController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/reqproduct")
	public String displayAddproductform(Model m,HttpSession hsession){
		m.addAttribute("productObject",new Product());
		//m.addAttribute("username", hsession.getAttribute("loginusername"));
		//m.addAttribute("userid",hsession.getAttribute("userimage"));
		m.addAttribute("userid", hsession.getAttribute("userimage"));
		m.addAttribute("imagenum",CommonController.generateRandomNum());
        return "addproduct";
        }
	@RequestMapping(value={"/addProductToDB"},method = RequestMethod.POST)
	public String addProductToDB(@Valid  @ModelAttribute("productObject")Product prd,Model m, HttpSession hsession,BindingResult result){	
       if(result.hasErrors())
    	   return "addproduct";
       
		m.addAttribute("username", hsession.getAttribute("loginusername"));
		productService.addProduct(prd);		
		return "redirect:/reqdisplayproductadmin";  // displays admin home page			
	}
	
	@RequestMapping("/reqdisplayproductadmin")
	public String displayproductadmin(Model m,HttpSession hsession){
		List<Product> data = productService.getProducts();
		m.addAttribute("products",data);
		//m.addAttribute("username", hsession.getAttribute("loginusername"));
		//m.addAttribute("userid",hsession.getAttribute("userimage"));
		m.addAttribute("userid", hsession.getAttribute("userimage"));
		m.addAttribute("imagenum", CommonController.generateRandomNum());
		return "displayproductadmin";
	}

	@RequestMapping("/reqDeleteProduct")
	public String deleteProductfromDb(@RequestParam("pid")String prdid){
		//System.out.println(prdid);
		productService.deleteProduct(prdid);
		return"redirect:/reqdisplayproductadmin";
	}
	
	@RequestMapping("/reqEditProductPage")
	public String editProduct(@RequestParam("pid")String pid,Model m,HttpSession hsession ){
		Product temp=productService.getProductById(pid);
		m.addAttribute("productObj",temp);
		m.addAttribute("userid", hsession.getAttribute("userimage"));
		return "editProductPage";
		}

	
	@RequestMapping("/reqEditProductToDb")
	public String editproducttodb(@ModelAttribute("productObj")Product prd){
	      productService.editProduct(prd);
	      return "redirect:/reqdisplayproductadmin";
	}
	
	
	
}
