package com.test1.dao;

import java.util.List;

import com.test1.model.Product;

public interface ProductDao {
	public abstract void addProduct(Product prd);
	public abstract List<Product> getProducts();
	public abstract Product getProductById(String pid);
	public abstract void deleteProduct(String prdid);
    public abstract void editProduct(Product prd);
    
}
