package com.test1.model;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {
	@Id
	private String productid;
	
	@NotEmpty(message="please enter prdname")
	private String productname;
	private String productdes;
	private boolean isproductavailable;
	
	@Transient //only for model it will not effect in the database
	private MultipartFile imagefile;

	public MultipartFile getImagefile() {
		return imagefile;
	}

	public void setImagefile(MultipartFile imagefile) {
		this.imagefile = imagefile;
	}
	
	
	

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductdes() {
		return productdes;
	}

	public void setProductdes(String productdes) {
		this.productdes = productdes;
	}

	public boolean isIsproductavailable() {
		return isproductavailable;
	}

	public void setIsproductavailable(boolean isproductavailable) {
		this.isproductavailable = isproductavailable;
	}
	
	}
	
	
