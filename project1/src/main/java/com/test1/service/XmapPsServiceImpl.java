package com.test1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test1.dao.XmapPsDao;
import com.test1.model.Xmap_product_Supplier;

@Service
public class XmapPsServiceImpl implements XmapPsService {

	@Autowired
	private XmapPsDao xpsdao;
	
	public void addXmapPs(Xmap_product_Supplier xps) {
		xpsdao.addXmapPs(xps);
		}

     public List<Xmap_product_Supplier> displayXmapPs() {
		return xpsdao.displayXmapPs();
	}
     public void deleteXmap_product_Supplier(String xpsid){
    	 xpsdao.deleteXmap_product_Supplier(xpsid);
     }

     public  Xmap_product_Supplier getXmap_product_SupplierById(String xpsid){
    	 return xpsdao.getXmap_product_SupplierById(xpsid);
     }
     
     public void editXmap_product_Supplier(Xmap_product_Supplier xps){
    	 xpsdao.editXmap_product_Supplier(xps);
     }
}
