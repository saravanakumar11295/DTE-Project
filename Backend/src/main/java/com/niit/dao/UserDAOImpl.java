package com.niit.dao;

import java.util.List;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.UserDetail;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO 
{
	
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	@Transactional  
	@Override
	public boolean registerUser(UserDetail user)
	{
		 try 
	     {
		 user.setEnabled(true);
			user.setRole("ROLE_USER");
		   sessionFactory.getCurrentSession().save(user);
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
	public boolean updateUserDetail(UserDetail user) 
	{
		try 
	     {
				sessionFactory.getCurrentSession().update(user);
				return true;
		 }
	    catch(Exception e)
	     {
				System.out.println("Exception Arised:"+e);
				return false;
		}
		
	}

	@Override
	public UserDetail getuser(String userName) 
	{
		Session session=sessionFactory.openSession();
		UserDetail userDetail=(UserDetail)session.get(UserDetail.class,userName);
		return userDetail;
	}
	@Transactional
	@Override
	public boolean deleteUserDetail(UserDetail user) {
		try 
	     {
			sessionFactory.getCurrentSession().delete(user);
			return true;
	     }
		catch(Exception e)
	     {
			System.out.println("Exception Arised:"+e);
			return false;
		 }
		
	}

	@Override
	public List<UserDetail> getuser() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from UserDetail");
		List<UserDetail> listuser=(List<UserDetail>)query.list();
		return listuser;	
	
	}

}
