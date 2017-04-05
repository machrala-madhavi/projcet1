package com.test1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test1.dao.ProductDao;
import com.test1.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	public void addProduct(Product prd) {
		productDao.addProduct(prd);
		}

	public List<Product> getProducts() {
		return productDao.getProducts();
	    }
	
	public Product getProductById(String pid) {
		return productDao.getProductById(pid);
	    }
	
		public void deleteProduct(String prdid){
			productDao.deleteProduct(prdid);
		}
		
		public void editProduct(Product prd){
			productDao.editProduct(prd);
		}
}
