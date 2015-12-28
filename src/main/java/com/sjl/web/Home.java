package com.sjl.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import beans.LoginBean;

@Controller
public class Home {

	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView model = new ModelAndView("index");
		LoginBean loginBean = new LoginBean();
		model.addObject("loginBean", loginBean);
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("loginBean") LoginBean loginBean)
	{
		ModelAndView model = null;
		try
		{

			boolean isValidUser = (loginBean.getUsername().equalsIgnoreCase("admin") && loginBean.getPassword().equals("pwd"));

			if (isValidUser)

			{
				System.out.println("User Login Successful");
				request.setAttribute("loggedInUser", loginBean.getUsername());
				model = new ModelAndView("loggedin");
			}
			else
			{
				model = new ModelAndView("index");
				model.addObject("loginBean", loginBean);
				request.setAttribute("message", "Invalid credentials!!");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return model;
	}


}
