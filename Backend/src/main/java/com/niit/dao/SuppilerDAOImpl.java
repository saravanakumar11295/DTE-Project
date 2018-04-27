package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Category;
import com.niit.model.Suppiler;

@Repository("suppilerDAO")
public class SuppilerDAOImpl implements SuppilerDAO 
{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public boolean addsuppiler(Suppiler suppiler)
	{
     try
          {
			sessionFactory.getCurrentSession().save(suppiler);
			return true;
		  }
     catch(Exception e)
		  {
			System.out.println("Exception Arised:"+e);
			return false;
		  }
     }
    @Override
	public Suppiler getsuppiler(int suppilerId)
    {
    	Session session=sessionFactory.openSession();
		Suppiler suppiler=(Suppiler)session.get(Suppiler.class,suppilerId);
		return suppiler;	
	}
    @Transactional
	@Override
	public boolean deletesuppiler(Suppiler suppiler)
    {
    	try
		   {
			sessionFactory.getCurrentSession().delete(suppiler);
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
	public boolean updatesuppiler(Suppiler suppiler) 
    {
    	try 
		   {
			sessionFactory.getCurrentSession().update(suppiler);
			return true;
		   }
		catch(Exception e)
		   {
			System.out.println("Exception Arised:"+e);
			return false;
		   }

	}

	@Override
	public List<Suppiler> getsuppiler() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Suppiler");
		List<Suppiler> listsuppiler=(List<Suppiler>)query.list();
		return listsuppiler;
	}

}
