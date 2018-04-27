package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.CartItem;

@Repository("CartDAO")
public class CartDAOImpl implements CartDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	
	@Transactional
	@Override
	public boolean addCartItem(CartItem cartItem) 
	{
		try {
			
			
		sessionFactory.getCurrentSession().save(cartItem);
		return true;
	        }
	catch(Exception e)
	    {
		System.out.println("Exception Arised:"+e);
		return false;
		}

	
	}
	@Transactional
	@Override
	public boolean updateCartItem(CartItem cartItem) {
		try 
		   {
			sessionFactory.getCurrentSession().update(cartItem);
			return true;
		   }
		catch(Exception e)
		   {
			System.out.println("Exception Arised:"+e);
			return false;
		   }
	}
	@Transactional
	@Override
	public boolean deleteCartItem(CartItem cartItem) 
	{
		try
		   {
			sessionFactory.getCurrentSession().delete(cartItem);
			return true;
		   }
		catch(Exception e)
		   {
			System.out.println("Exception Arised:"+e);
			return false;
		   }
	}
	@Transactional
	@Override
	public CartItem getCartItem(int cartItemId) {
		Session session=sessionFactory.openSession();
		CartItem cartItem=(CartItem)session.get(CartItem.class,cartItemId);
		return cartItem;
	}

	@Override
	public List<CartItem> getCartItems(String username) 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from CartItem where userName=:username and paymentStatus='NP'");
		query.setParameter("username",username);
		List<CartItem> listcategories=(List<CartItem>)query.list();
		return listcategories;
	}
	
	
		
}
