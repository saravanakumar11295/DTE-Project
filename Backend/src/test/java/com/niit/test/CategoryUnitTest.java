package com.niit.test;

import static org.junit.Assert.*;



import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;


public class CategoryUnitTest {

	static CategoryDAO categoryDAO; 

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
	 categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
	
	@Ignore
	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		category.setCategoryName("sofa");
		category.setCateogryDesc("All types of sofa");
		assertTrue("problem in category insertion",categoryDAO.addCategory(category));
	}
	@Ignore
	@Test
	public void getCategoryTest()
	{
		assertNotNull("problem in get category",categoryDAO.getCategory(2));
	}
    @Ignore
	@Test
	public void deleteCategoryTest()
	
	{
		Category category=categoryDAO.getCategory(3);
		assertTrue("problem in delete category",categoryDAO.deleteCategory(category));

	}
    @Ignore
	@Test
	public void updateCategoryTest() 
	{
		Category category=categoryDAO.getCategory(4);
		category.setCategoryName("SARAVANA");
		assertTrue("problem in updatecategory",categoryDAO.updateCategory(category));
	}
    @Test
	public void listCategoriesTest()
	{
		List<Category> listCategories=categoryDAO.getCategories();
		assertNotNull("no categories",listCategories);
		
		for(Category category:listCategories)
		{
			System.out.print(category.getCategoryId()+":::");
			System.out.print(category.getCategoryName()+":::");
			System.out.println(category.getCateogryDesc()+":::");
		}
	}

}

