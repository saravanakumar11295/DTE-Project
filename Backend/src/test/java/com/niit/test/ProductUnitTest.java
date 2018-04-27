package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDAO;
import com.niit.model.Product;


public class ProductUnitTest {

	static ProductDAO productDAO; 

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
	 productDAO=(ProductDAO)context.getBean("productDAO");
	}
    
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProductName("Iphone x");
		product.setProductDesc("pass@123");
		product.setStock(2);
		product.setCategoryId(1);
		product.setPrice(100000);
		product.setSupplierId(1);
		assertTrue("problem in product insertion",productDAO.addProduct(product));
	}
    @Ignore
	@Test
	public void getProductTest()
	{
		assertNotNull("problem in get product",productDAO.getProduct(2));
	}
    @Ignore
    @Test
	public void deleteProductTest()
	
	{
		Product product=productDAO.getProduct(1);
		assertTrue("problem in delete product",productDAO.deleteProduct(product));

	}
    @Ignore
    @Test
	public void updateProductTest() 
	{
		Product product=productDAO.getProduct(2);
		product.setProductName("Iphone 7 plus");
		assertTrue("problem in updateproduct",productDAO.updateProduct(product));
	}
    @Ignore
    @Test
	public void listProductTest()
	{
		List<Product> listproduct=productDAO.getProduct();
		assertNotNull("no categories",listproduct);
		
		for(Product product:listproduct)
		{
			System.out.print(product.getProductId()+":::");
			System.out.print(product.getProductName()+":::");
			System.out.println(product.getProductDesc()+":::");
		}

     }
}

