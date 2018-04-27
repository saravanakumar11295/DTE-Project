package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CartDAO;
import com.niit.model.CartItem;
import com.niit.model.Category;

public class CartUnitTest {

	static CartDAO cartDAO; 

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
	 cartDAO=(CartDAO)context.getBean("CartDAO");
	}
	@Ignore
	@Test
	public void addCartTest()
	{
		CartItem cartItem =new CartItem();
		cartItem.setCartId(1001);
		cartItem.setProductId(2);
		cartItem.setQuantity(1);
		cartItem.setUserName("U1001");
		cartItem.setPaymentStatus("NP");
		cartItem.setSubtotal(1999);
		assertTrue("Problem in cart item insertion",cartDAO.addCartItem(cartItem));
	}
	@Ignore
	@Test
	public void getCartTest()
	{
		assertNotNull("problem in get category",cartDAO.getCartItem(2));
	}
	@Ignore
	@Test
    public void deleteCartTest()
	
	{
		CartItem cartItem=cartDAO.getCartItem(2);
		assertTrue("problem in delete category",cartDAO.deleteCartItem(cartItem));

	}
	@Ignore
	@Test
	public void updateCartTest() 
	{
		CartItem cartItem=cartDAO.getCartItem(1);
		cartItem.setUserName("SARAVANA");
		assertTrue("problem in updatecategory",cartDAO.updateCartItem(cartItem));
	}
	@Test
	public void listCartTest()
	{
		List<CartItem> listCart=cartDAO.getCartItems("SARAVANA");
		assertNotNull("no categories",listCart);
		System.out.println(listCart.size());
		
		for(CartItem cartItem:listCart)
		{
			System.out.println("inside for loop");
			System.out.print(cartItem.getProductId()+":::");
			System.out.print(cartItem.getQuantity()+":::");
			System.out.println(cartItem.getSubtotal()+":::");
			
		}
	}





}
