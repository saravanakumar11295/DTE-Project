package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.CartDAO;
import com.niit.dao.ProductDAO;
import com.niit.model.CartItem;
import com.niit.model.Product;

@Controller
public class CartController
{
	@Autowired
	CartDAO cartDAO;
	@Autowired
	ProductDAO productDAO;
	
	
	@RequestMapping("/cart")
	public String showCartPage(Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("userName");
		List<CartItem> cartList=cartDAO.getCartItems(username);
	    m.addAttribute("cartList",cartList);

		return "Cart";
     }

	
	@RequestMapping("/addToCart/{productId}")
	public String addCartItem(@PathVariable("productId")int productId,@RequestParam("quantity")int quantity,HttpSession session,Model m )
	{ 
		CartItem cartItem=new CartItem();
		Product product=productDAO.getProduct(productId);
		
		String username=(String)session.getAttribute("userName");
		
		cartItem.setCartId(1001);
		cartItem.setProductId(productId);
		cartItem.setQuantity(quantity);
		cartItem.setUserName(username);
		cartItem.setPaymentStatus("NP");
		cartItem.setSubtotal(quantity*product.getPrice());
		
		cartDAO.addCartItem(cartItem);
		List<CartItem> listCartItem=cartDAO.getCartItems(username);
		m.addAttribute("cartList",listCartItem);
		m.addAttribute("grandTotal",this.grandTotal(listCartItem));	
		
		return "Cart";
	}
	@RequestMapping("/editCart/{cartItemId}")
	public String editCartItems(@PathVariable("cartItemId")int cartItemId,@RequestParam("qty")int quantity,Model m, HttpSession session)
	{
		CartItem cartItem = cartDAO.getCartItem(cartItemId);
		Product product=productDAO.getProduct(cartItem.getProductId());
		cartItem.setQuantity(quantity);
		cartItem.setSubtotal(quantity*product.getPrice());
		cartDAO.updateCartItem(cartItem);
		
		String username = (String)session.getAttribute("userName");
		List<CartItem> listCartItem=cartDAO.getCartItems(username);
		m.addAttribute("cartList",listCartItem);
		m.addAttribute("grandTotal",this.grandTotal(listCartItem));
		return "Cart";
		
	}
	
	@RequestMapping("/deleteCart/{cartItemId}")
	public String deleteCartItems(@PathVariable("cartItemId")int cartItemId,Model m, HttpSession session)
	{
		CartItem cartItem = cartDAO.getCartItem(cartItemId);
		cartDAO.deleteCartItem(cartItem);
		
		
		
		String username = (String)session.getAttribute("userName");
		List<CartItem> listCartItem=cartDAO.getCartItems(username);
		m.addAttribute("cartList",listCartItem);
		m.addAttribute("grandTotal",this.grandTotal(listCartItem));
		
		
		return "Cart";
		
	}
	public int grandTotal(List<CartItem> listcartItems)
	{
	 int grandTotal=0;
	 for(CartItem cartItem:listcartItems)
	 {
		 grandTotal=grandTotal+cartItem.getQuantity()*(productDAO.getProduct(cartItem.getProductId()).getPrice());
	 }
	 return grandTotal;
	}


}
