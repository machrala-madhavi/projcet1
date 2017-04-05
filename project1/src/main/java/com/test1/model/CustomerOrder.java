package com.test1.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class CustomerOrder implements Serializable {
	
	@Id
	private String orderId;
	
	@OneToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name="billingAddress_id")
	private BillingAddress billingAddress;

	@OneToOne
	@JoinColumn(name="shippingAddress_id")
	private ShippingAddress shippingAddress;

	@OneToOne
	@JoinColumn(name="cart_id")
	private Cart cart;
	
	@OneToMany(mappedBy="customerOrder",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<CustomerOrderHistory>customerOrderHistory;

private Date orderDate;
	
	private String custid;
	
	private String shippedaddress;
	
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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

	public List<CustomerOrderHistory> getCustomerOrderHistory() {
		return customerOrderHistory;
	}

	public void setCustomerOrderHistory(List<CustomerOrderHistory> customerOrderHistory) {
		this.customerOrderHistory = customerOrderHistory;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	public String getShippedaddress() {
		return shippedaddress;
	}

	public void setShippedaddress(String shippedaddress) {
		this.shippedaddress = shippedaddress;
	}
	
	

}
