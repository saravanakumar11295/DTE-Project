package com.niit.controller;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.dao.SuppilerDAO;
import com.niit.model.Suppiler;

@Controller
public class SuppilerController {
	@Autowired
	SuppilerDAO supplierDAO;
	
	@RequestMapping(value="/supplier")
	public String showSupplier(Model m) 
	{
		Suppiler suppiler = new Suppiler();
		m.addAttribute("supplier", suppiler);
		List<Suppiler> supplierList = supplierDAO.getsuppiler();
		m.addAttribute("listsuppiler", supplierList);

		return "Supplier";
	}
	@RequestMapping(value="/InsertSuppiler",method=RequestMethod.POST)
	public String addSuppiler(@ModelAttribute("supplier")Suppiler suppiler,Model m)
	{
		Suppiler sup=new Suppiler();
		m.addAttribute(sup);
		supplierDAO.addsuppiler(suppiler);
		System.out.println(" SuppilerName:"+suppiler.getSuppilerName());
		System.out.println("SuppilerMobileNo:"+suppiler.getSuppilerMobileNo());
		List<Suppiler> supplierList = supplierDAO.getsuppiler();
		m.addAttribute("listsuppiler", supplierList);

        return "Supplier";
	}
	

}
