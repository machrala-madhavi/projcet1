package com.test1.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.Valid;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Customer implements Serializable {

	@Id
	private String customerid;
	
	
	private String custname;
	
	
	private String custemailid;
	
	
	
	private String custmobileno;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userid")
    private SignUp1 signUp1;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="billingaddressid")
	private BillingAddress billingAddress;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="shippinaddressid")
	
	private ShippingAddress shippingAddress;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cartid")
	private Cart cart;

	public String getCustomerid() {
		return customerid;
	}  

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	

	public String getCustemailid() {
		return custemailid;
	}

	public void setCustemailid(String custemailid) {
		this.custemailid = custemailid;
	}

	public String getCustmobileno() {
		return custmobileno;
	}
   
	public void setCustmobileno(String custmobileno) {
		this.custmobileno = custmobileno;
	}

	public SignUp1 getSignUp1() {
		return signUp1;
	}

	public void setSignUp1(SignUp1 signUp1) {
		this.signUp1 = signUp1;
	}

	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}
	
	
	
}
