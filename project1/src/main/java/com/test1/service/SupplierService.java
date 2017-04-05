package com.test1.service;

import java.util.List;

import com.test1.model.Supplier;



public interface SupplierService {
	public abstract void addSupplier(Supplier sup);
    public abstract List<Supplier> getSuppliers();
    public Supplier getSupplierById(String supid);
    public abstract void deleteSupplier(String supid);
    public abstract void editSupplier(Supplier sup);

}
