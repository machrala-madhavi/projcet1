package com.test1.service;

import java.util.List;

import com.test1.model.Xmap_product_Supplier;

public interface XmapPsService {
	
	public abstract void addXmapPs(Xmap_product_Supplier xps);
	public abstract List<Xmap_product_Supplier> displayXmapPs();
    public abstract void deleteXmap_product_Supplier(String xpsid);
    public abstract Xmap_product_Supplier getXmap_product_SupplierById(String xpsid);
    public abstract void editXmap_product_Supplier(Xmap_product_Supplier xps);
}


