package com.niit.controller;

import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.niit.dao.UserDAO;
import com.niit.model.UserDetail;

@Controller

public class UserDetailController {
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping("/signup")
	public String showSignup(Model m)
	{
		UserDetail user=new UserDetail();
		m.addAttribute("user",user);
		return "SignUp";
	}
	
	@RequestMapping(value="/adduserDetail",method=RequestMethod.POST)
	public String addUserDetail(@ModelAttribute("user")UserDetail userDetail, Model m)
	{
		userDAO.registerUser(userDetail);
        m.addAttribute("user",userDetail);
        
        List<UserDetail> listuser=userDAO.getuser();
	    m.addAttribute("listUserDetails",listuser);
	    
		return "Login";
	}
	
	@RequestMapping("/login_success")
	public String showSuccessPage(HttpSession session,Model m)
	{
		String Page="";
		boolean loggedIn = false;
		SecurityContext securityContext=SecurityContextHolder.getContext();
		Authentication authentication=securityContext.getAuthentication();
		String userName=authentication.getName();
		Collection<GrantedAuthority> roles = (Collection<GrantedAuthority>)securityContext.getAuthentication().getAuthorities();
		
		for(GrantedAuthority role:roles)
		{
		session.setAttribute("role", role.getAuthority());
		if(role.getAuthority().equals("ROLE_ADMIN"))
		  {
			loggedIn=true;
			Page="index";
			session.setAttribute("loggedIn", loggedIn);
			session.setAttribute("userName", userName);
	      }
		else
		{
			System.out.println("After logging in: ");
			loggedIn=true;
			Page="index";
			session.setAttribute("loggedIn",loggedIn);
			session.setAttribute("userName",userName);
		}
		
		
	}
		return Page;
}
}


