package com.test1.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Supplier {
@Id
private String supplierid;
private String suppliername;
private String supplierdesc;
private boolean issupplieravailable;
@Transient //only for model it will not effect in the database
private MultipartFile imagefile;


public MultipartFile getImagefile() {
	return imagefile;
}
public void setImagefile(MultipartFile imagefile) {
	this.imagefile = imagefile;
}
public String getSupplierid() {
	return supplierid;
}
public void setSupplierid(String supplierid) {
	this.supplierid = supplierid;
}
public String getSuppliername() {
	return suppliername;
}
public void setSuppliername(String suppliername) {
	this.suppliername = suppliername;
}
public String getSupplierdesc() {
	return supplierdesc;
}
public void setSupplierdesc(String supplierdesc) {
	this.supplierdesc = supplierdesc;
}
public boolean isIssupplieravailable() {
	return issupplieravailable;
}
public void setIssupplieravailable(boolean issupplieravailable) {
	this.issupplieravailable = issupplieravailable;
}

}
