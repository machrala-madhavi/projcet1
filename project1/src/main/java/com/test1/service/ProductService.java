package com.test1.service;

import java.util.List;

import com.test1.model.Product;

public interface ProductService {
      public abstract void addProduct(Product prd);
      public abstract List<Product> getProducts();
      public abstract void deleteProduct(String prdid);
      public abstract Product getProductById(String pid);
      public abstract void editProduct(Product prd);
      
}
