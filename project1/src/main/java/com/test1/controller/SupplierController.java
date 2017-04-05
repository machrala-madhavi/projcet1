package com.test1.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test1.model.Product;
import com.test1.model.Supplier;
import com.test1.model.Vw_Xmap_ps;
import com.test1.model.Xmap_product_Supplier;
import com.test1.service.ProductService;
import com.test1.service.SupplierService;
import com.test1.service.VmPsService;
import com.test1.service.XmapPsService;

@Controller
public class SupplierController {
	
	@Autowired
	private SupplierService supplierService;
	
@Autowired
private ProductService productService;

	@Autowired
	private XmapPsService xpsservice;
	
	@Autowired
	private VmPsService vwpsservice;
	
	
	@RequestMapping("/reqaddsupplier")
	public String displayAddSupplierForm(Model m,HttpSession hsession){
        //m.addAttribute("supplierObject1",new Supplier());
       // m.addAttribute("username",hsession.getAttribute("userlogedin"));
		m.addAttribute("supplierObject", new Supplier());
	     //m.addAttribute("userimage", hsession.getAttribute("userlogin"));
		//m.addAttribute("username", hsession.getAttribute("userlogedin"));
		//m.addAttribute("userlogin",hsession.getAttribute("imagenum"));
		m.addAttribute("userid", hsession.getAttribute("userimage"));	
		m.addAttribute("imagenum", CommonController.generateRandomNum());
		return "addsupplier";
	}

	/*@RequestMapping(value={"/addSupplierToDB"},method = RequestMethod.POST)
	public String addSupplierToDb(@ModelAttribute("supplierObject")Supplier sup){	
		System.out.println(sup.getSuppliername());
		supplierService.addSupplier(sup);		
		return "signinsucessadmin";  // displays admins home page			
	}
	
	@RequestMapping("/reqdisplaysupplieradmin")
	public String displaySuppliersAdmin(Model m){
		List<Supplier> data = supplierService.getSuppliers();
		m.addAttribute("supplier",data);
		return "displaysupplieradmin";
	}
	
	
}*/
	@RequestMapping("/addSupplierToDB")
	public String addSupplierToDB(@ModelAttribute("supplierObject")Supplier sup,Model m,HttpSession hsession){
       m.addAttribute("username",hsession.getAttribute("userlogedin"));
       System.out.println(sup.getSuppliername());
		
		m.addAttribute("username", hsession.getAttribute("userlogedin"));
       supplierService.addSupplier(sup);
		return "redirect:/reqdisplaysupplieradmin";
	}
	
	@RequestMapping("/reqdisplaysupplieradmin")
	public String displaySuppliers(Model m,HttpSession hsession ){
		List<Supplier> data = supplierService.getSuppliers();
     //   m.addAttribute("username",hsession.getAttribute("userlogedin"));
		m.addAttribute("suppliersData", data);
		//m.addAttribute("imagenum", CommonController.generateRandomNum());
//		m.addAttribute("username", hsession.getAttribute("userlogedin"));
		m.addAttribute("userid", hsession.getAttribute("userimage"));
		m.addAttribute("userlogin",hsession.getAttribute("imagenum"));
		return "displaysupplieradmin";
	}
	@RequestMapping("/reqEditSupplierpage")
	public String editSupplier(@RequestParam("Sid")String supid,Model model,HttpSession hsession){
		Supplier temp=supplierService.getSupplierById(supid);
		model.addAttribute("supplierObj", temp);
		model.addAttribute("userid", hsession.getAttribute("userimage"));
		return "editSupplierPage";
	}
	
	@RequestMapping("reqEditSupplierToDb")
	public String editSupplier(@ModelAttribute("supplierObj")Supplier sup){
		supplierService.editSupplier(sup);
		return "redirect:/reqdisplaysupplieradmin";
	}
	
	//.........................................................................................
	
	@RequestMapping("/reqaddprodsupp")
	public String displayAddProdSupp(Model m,HttpSession hsession){
	
		List<Product> prdata = productService.getProducts();
		List<Supplier> supdata = supplierService.getSuppliers();
		m.addAttribute("products",prdata);
		m.addAttribute("suppliers", supdata);
		m.addAttribute("prodsuppObject", new Xmap_product_Supplier());
		//m.addAttribute("userimage", hsession.getAttribute("userlogin"));
		//m.addAttribute("username", hsession.getAttribute("userlogedin"));
		//m.addAttribute("username", hsession.getAttribute("userlogedin"));
		//m.addAttribute("userlogin",hsession.getAttribute("imagenum"));
		m.addAttribute("userid", hsession.getAttribute("userimage"));
		m.addAttribute("imagenum", CommonController.generateRandomNum());
		return "addprodsupp";
	}
	
	@RequestMapping("/reqaddprodsuppDataToDb")
	public String addProdSuppToDb(@ModelAttribute("prodsuppObject1")Xmap_product_Supplier xps,Model m,HttpSession hsession){
		m.addAttribute("username", hsession.getAttribute("userlogedin"));
		//System.out.println(xps.getProductid());
		xpsservice.addXmapPs(xps);
		return "redirect:/reqdisplayXps";
	}
	
	@RequestMapping("/reqdisplayXps")
	public String displayXps(Model m,HttpSession hsession){
		List<Xmap_product_Supplier> xpsdata =  xpsservice.displayXmapPs();
		m.addAttribute("xpsdata", xpsdata);
//		m.addAttribute("username", hsession.getAttribute("userlogedin"));
	//	m.addAttribute("userlogin",hsession.getAttribute("imagenum"));
		m.addAttribute("userid", hsession.getAttribute("userimage"));
		m.addAttribute("imagenum", CommonController.generateRandomNum());
		return "displayXps";
	}
	
	
	@RequestMapping("/reqDeleteXmap_product_Supplier")
	public String deleteXmap_product_Supplier(@RequestParam("psid")String xpsid){
		xpsservice.deleteXmap_product_Supplier(xpsid);
		return "redirect:/reqdisplayXps";
	}

	@RequestMapping("/reqeditXPS")
	public String editXps(@RequestParam("psid")String xpsid,Model model,HttpSession hsession){
		Xmap_product_Supplier temp =xpsservice.getXmap_product_SupplierById(xpsid);
		model.addAttribute("xpsObj",temp);
		model.addAttribute("userid", hsession.getAttribute("userimage"));
		return"editXPS";
	}
	
	@RequestMapping("/reqEditXpsToDb")
	public String editXmap_product_Supplier(@ModelAttribute("xpsObj")Xmap_product_Supplier xps,Model model,HttpSession hsession){
		xpsservice.editXmap_product_Supplier(xps);
		model.addAttribute("userid", hsession.getAttribute("userimage"));
		return "redirect:/reqdisplayXps";
	}
	//.............................................................................................................
//DELETE MAPPING REQUEST FOR SUPPLIERS
	@RequestMapping("/reqdeleteSupplier")
	public String deleteSupplier(@RequestParam("Sid")String supid){
	//System.out.println(supid);
		supplierService.deleteSupplier(supid);
		return "redirect:/reqdisplaysupplieradmin";
	}

//...............................................................................................................
/*@RequestMapping("/reqDisplayProductsUser")
public String displayProductsUser(Model m){
	List<Vw_Xmap_ps> psdata = vwpsservice.getVwPs(); 
	//List<Vw_Xmap_ps> psdata = vwpsservice.getBestVwPs(); 
	m.addAttribute("psdata", psdata);
	return "displayproductsuser";
}*/


}