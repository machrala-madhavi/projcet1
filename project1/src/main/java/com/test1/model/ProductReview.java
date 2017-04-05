package com.test1.model;

import javax.persistence.Id;

public class ProductReview {
	
	@Id
	private String reviewid;
	private String customerid;
	private String customerorderhistoryid;
	private String productid;
	private int rating;
	private String comments;
	public String getReviewid() {
		return reviewid;
	}
	public void setReviewid(String reviewid) {
		this.reviewid = reviewid;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getCustomerorderhistoryid() {
		return customerorderhistoryid;
	}
	public void setCustomerorderhistoryid(String customerorderhistoryid) {
		this.customerorderhistoryid = customerorderhistoryid;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	

	
	

}
