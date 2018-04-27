package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SuppilerDAO;
import com.niit.model.Category;
import com.niit.model.Suppiler;

public class SuppilerUnitTest {

	static SuppilerDAO suppilerDAO; 

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
	 suppilerDAO=(SuppilerDAO)context.getBean("suppilerDAO");
	}
	@Ignore
	@Test
	public void addsuppilerTest()
	{
		Suppiler suppiler=new Suppiler();
		suppiler.setSuppilerName("kowshika");
		suppiler.setSuppilerMobileNo("9865940407");
		assertTrue("problem in suppiler insertion",suppilerDAO.addsuppiler(suppiler));
	}
	@Ignore
	@Test
	public void getSuppilerTest()
	{
		assertNotNull("problem in get suppiler",suppilerDAO.getsuppiler(2));
	}
	@Ignore
	@Test
	public void deleteSuppilerTest()
	
	{
		Suppiler suppiler=suppilerDAO.getsuppiler(2);
		assertTrue("problem in delete suppiler",suppilerDAO.deletesuppiler(suppiler));

	}
	@Ignore
	@Test
	public void updateSuppilerTest() 
	{
		Suppiler suppiler=suppilerDAO.getsuppiler(3);
		suppiler.setSuppilerName("kowshi");
		assertTrue("problem in updatesuppiler",suppilerDAO.updatesuppiler(suppiler));
	}
	@Test
	public void listSuppilerTest()
	{
		List<Suppiler> listSuppiler=suppilerDAO.getsuppiler();
		assertNotNull("no categories",listSuppiler);
		
		for(Suppiler suppiler:listSuppiler)
		{
			System.out.println(suppiler.getSuppilerId()+":::");
			System.out.println(suppiler.getSuppilerName()+":::");
			System.out.println(suppiler.getSuppilerMobileNo()+":::");
		}
	}


}
