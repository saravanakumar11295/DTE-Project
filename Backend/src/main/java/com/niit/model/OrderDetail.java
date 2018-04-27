package com.niit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class OrderDetail
{
	@Id
	int cartId;
	
	String username;
	Date orderDate;
	int totalAmount;
	String shippingAddress;
	String transactiontype;
	
	public int getCartId()
	{
		return cartId;
	}
	public void setCartId(int cartId) 
	{
		this.cartId = cartId;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public Date getOrderDate() 
	{
		return orderDate;
	}
	public void setOrderDate(Date orderDate)
	{
		this.orderDate = orderDate;
	}
	public int getTotalAmount()
	{
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount)
	{
		this.totalAmount = totalAmount;
	}
	public String getShippingAddress()
	{
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) 
	{
		this.shippingAddress = shippingAddress;
	}
	public String getTransactiontype()
	{
		return transactiontype;
	}
	public void setTransactiontype(String transactiontype) 
	{
		this.transactiontype = transactiontype;
	}
	

}
