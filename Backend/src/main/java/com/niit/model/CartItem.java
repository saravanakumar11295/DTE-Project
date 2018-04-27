package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class CartItem 
{
  @Id
  @GeneratedValue
  int cartItemId;
  int cartId;
  int productId;
  int quantity;
  int subtotal;
  
  String userName;
  String paymentStatus;
  
public int getCartItemId() 
{
	return cartItemId;
}
public void setCartItemId(int cartItemId) 
{
	this.cartItemId = cartItemId;
}
public int getCartId() 
{
	return cartId;
}
public void setCartId(int cartId) 
{
	this.cartId = cartId;
}
public int getProductId() 
{
	return productId;
}
public void setProductId(int productId) 
{
	this.productId = productId;
}
public int getQuantity() 
{
	return quantity;
}
public void setQuantity(int quantity) 
{
	this.quantity = quantity;
}
public int getSubtotal() 
{
	return subtotal;
}
public void setSubtotal(int subtotal) 
{
	this.subtotal = subtotal;
}
public String getUserName() 
{
	return userName;
}
public void setUserName(String userName) 
{
	this.userName = userName;
}
public String getPaymentStatus() 
{
	return paymentStatus;
}
public void setPaymentStatus(String paymentStatus) 
{
	this.paymentStatus = paymentStatus;
}
  
  
  
  
}
