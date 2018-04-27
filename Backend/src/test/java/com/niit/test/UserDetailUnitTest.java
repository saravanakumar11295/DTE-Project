package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDAO;
import com.niit.model.Product;
import com.niit.model.UserDetail;

public class UserDetailUnitTest
{

	static UserDAO userDAO; 

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
	 userDAO=(UserDAO)context.getBean("userDAO");
	
	}
	@Ignore
	@Test
	public void registerUserTest()
	{
		UserDetail user=new UserDetail();
		user.setUserName("saravanaalagar");
		user.setPassword("pass@123");
		user.setRole("ROLE_ADMIN");
		//user.setRole("ROLE_USER");
		user.setEnabled(true);
		//user.setEnable("False");
		user.setCustomerName("Saravanakumar");
		user.setMobileNo("8056419811");
		user.setAddress("madurai");
		user.setEmailId("saravanaalagar1@gmail.com");
		assertTrue("problem in product insertion",userDAO.registerUser(user));
	}
	@Ignore
	@Test
	public void getUserTest()
	{
		assertNotNull("problem in get user",userDAO.getuser("saravanaalagar"));
	}
	@Ignore
	@Test
	public void deleteUserTest()
	
	{
		UserDetail userDetail=userDAO.getuser("saravanaalagar");
		assertTrue("problem in delete user",userDAO.deleteUserDetail(userDetail));

	}
	@Ignore
    @Test
    public void updateUserDetailTest() 
	{
	   UserDetail userDetail=userDAO.getuser("saravanaalagar");
	   userDetail.setCustomerName("saravana");
	   assertTrue("problem in update user",userDAO.updateUserDetail(userDetail));
    }
	@Test
	public void listProductTest()
	{
		List<UserDetail> listuser=userDAO.getuser();
		assertNotNull("no categories",listuser);
		
		for(UserDetail userDetail:listuser)
		{
			System.out.print(userDetail.getUserName()+":::");
			System.out.print(userDetail.getCustomerName()+":::");

		}

     }	
}
