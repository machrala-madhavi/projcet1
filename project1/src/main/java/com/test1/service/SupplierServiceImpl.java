package com.test1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test1.dao.SupplierDao;
import com.test1.model.Supplier;



@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierDao supplierDao;
	
	public void addSupplier(Supplier sup) {
	supplierDao.addSupplier(sup);
		}

	public List<Supplier> getSuppliers() {
		return supplierDao.getSuppliers();
	    }
	
	public Supplier getSupplierById(String supid){
		return supplierDao.getSupplierById(supid);
	     }

	public void deleteSupplier(String supid){
		supplierDao.deleteSupplier(supid);
	}

	public void editSupplier(Supplier sup){
		supplierDao.editSupplier(sup);
	}
}
