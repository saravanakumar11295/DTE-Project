package com.niit.controller;

	import java.io.BufferedOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;

    import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.dao.CategoryDAO;
    import com.niit.dao.ProductDAO;
    import com.niit.model.Category;
	import com.niit.model.Product;

	@Controller
	public class ProductController 
	{
		@Autowired
		CategoryDAO categoryDAO;
		
		@Autowired
		ProductDAO productDAO;
		
		@RequestMapping("/product")
		public String showProductPage(Model m)
		{
			Product product=new Product();
			m.addAttribute(product);
		    m.addAttribute("catlist",this.listCategories());
			List<Product> listproduct=productDAO.getProduct();
		    m.addAttribute("listproduct",listproduct);

			return "Product";
	     }
		
		@RequestMapping(value="/InsertProduct",method=RequestMethod.POST)
		public String addproduct(@ModelAttribute("product")Product product,Model m,@RequestParam("pimage")MultipartFile filedet,BindingResult result)
		{
			Product product1=new Product();
			m.addAttribute(product1);
			productDAO.addProduct(product);
			String imagePath="G://web project/Frontend/src/main/webapp/resources/images/";
			imagePath=imagePath+String.valueOf(product.getProductId())+".jpg";
			File image= new File(imagePath);
			
			if(!filedet.isEmpty())
			{
				try
				{
					byte[] fileBuffer=filedet.getBytes();
					FileOutputStream fos=new FileOutputStream(image);
					BufferedOutputStream bs=new BufferedOutputStream(fos);
					bs.write(fileBuffer);
					bs.close();
				}catch (Exception e)
				{
					System.out.println("Exception Araised:"+e);
					e.printStackTrace();
				}
				
			}
			else
			{
				System.out.println("problem occuring in file uploding");
			}
			System.out.println("Product Name:"+product.getProductName());
			System.out.println("Product price:"+product.getPrice());
			m.addAttribute("catlist",this.listCategories());
			List<Product> listProducts = productDAO.getProduct();
			m.addAttribute("listproduct", listProducts);
            return "Product";
		}
		public LinkedHashMap<Integer,String> listCategories()
		{
			List<Category> listCategories=categoryDAO.getCategories();
			 
			LinkedHashMap<Integer,String> catlist= new LinkedHashMap<Integer,String>();
			for(Category category:listCategories)
			{
				catlist.put(category.getCategoryId(),category.getCategoryName());
			}
			return catlist;
		}
		@RequestMapping("/deleteProduct/{productId}")
		public String deleteProduct(@PathVariable("productId")int productId,Model m)
		{
			Product product=productDAO.getProduct(productId);
			
			productDAO.deleteProduct(product); 
			Product prod=new Product();
			m.addAttribute(prod);
			
			List<Product> listproduct=productDAO.getProduct();
		    m.addAttribute("listproduct",listproduct);
		   
		    return "Product";
	   }
		@RequestMapping("/updateProduct/{productId}")
		public String updateProduct(@PathVariable("productId")int productId,Model m)
		{
			Product product=productDAO.getProduct(productId);
			m.addAttribute("product",product);
            List<Product> listproduct=productDAO.getProduct();
		    m.addAttribute("listproduct",listproduct);    
			return "UpdateProduct";			
		}
		
		@RequestMapping(value="/updateProduct", method=RequestMethod.POST)
		public String updateproductinDB(@ModelAttribute("product")Product product,Model m)
		{
			productDAO.updateProduct(product);
			List<Product> listproduct=productDAO.getProduct();
		    m.addAttribute("listproduct",listproduct);
		    return "Product";
		}
		@RequestMapping(value="/productPage",method=RequestMethod.GET)
		public String showproductspage(Model m)
		{
			List<Product> listProducts = productDAO.getProduct();
			m.addAttribute("listProducts", listProducts);
			
			return "ProductPage";
		}
		@RequestMapping(value="/productDesc/{productId}",method=RequestMethod.GET)
		public String showproductDesc(@PathVariable("productId")int productId,Model m)
		{
			Product product=productDAO.getProduct(productId);
			m.addAttribute("ProductInfo",product);
			return "ProductDesc";
		}
}

