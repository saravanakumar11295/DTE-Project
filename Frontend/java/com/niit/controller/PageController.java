package com.niit.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.model.Category;
import com.niit.model.UserDetail;

@Controller
public class PageController {
	@RequestMapping("/")
	public String showpage()
	{
		return "index";
	}
	@RequestMapping("/Home")
	public String showHomepage()
	{
		return "index";
	}
	@RequestMapping("/login")
    public String login(Model m)
	{
		UserDetail user = new UserDetail();
		m.addAttribute("user", user);
		return "Login";
	}
	@RequestMapping("/aboutus")
    public String aboutus()
	{
		return "AboutUs";
	}
	

}
