package com.niit.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.CartDAO;
import com.niit.dao.ProductDAO;
import com.niit.model.CartItem;
import com.niit.model.OrderDetail;

@Controller
public class OrderDetailController
{
	@Autowired
	CartDAO cartItemDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	
	@RequestMapping("/viewOrders")
	public String viewOrders(HttpSession session, Model m)
	{
		String username = (String)session.getAttribute("userName");
		List<CartItem> cartList = cartItemDAO.getCartItems(username);		
		m.addAttribute("cartList",cartList);
		return "OrderConfirmation";
	}
	
	@RequestMapping("/ConfirmOrder")
	public String confirmOrder(HttpSession session, Model m)
	{
		OrderDetail order = new OrderDetail();
		m.addAttribute("order", order);
		
		String username = (String)session.getAttribute("userName");
		
		List<CartItem> listCartItem = cartItemDAO.getCartItems(username);
		m.addAttribute("cartList", listCartItem);
		m.addAttribute("grandTotal",this.grandTotal(listCartItem));
		return "OrderConfirmation";
	}
	
	public int grandTotal(List<CartItem> listCartItem)
	{
		int grandTotal=0;
		for(CartItem cartItem:listCartItem)
		{
			grandTotal=grandTotal+cartItem.getQuantity()*(productDAO.getProduct(cartItem.getProductId()).getPrice());
			
		}
		
		return grandTotal;
	}
	@RequestMapping("/thankYou")
	public String addOrderDetail(@ModelAttribute("order")OrderDetail orderDetail, HttpSession session, Model m) 
	{
		String username = (String)session.getAttribute("userName");
		
		List<CartItem> listCartItems = cartItemDAO.getCartItems(username);
		m.addAttribute("cartList", listCartItems);
				
		orderDetail.setCartId(listCartItems.get(0).getCartId());		
		orderDetail.setUsername(username);
		orderDetail.setTotalAmount(this.grandTotal(listCartItems));
		orderDetail.setOrderDate(new Date());

		
		for(CartItem cartItem:listCartItems) 
		{
			cartItem.setPaymentStatus("P");
			cartItemDAO.updateCartItem(cartItem);
			
		}
		
		m.addAttribute("shippingAddress", orderDetail.getShippingAddress());
		return "thankyou";
	}

}
