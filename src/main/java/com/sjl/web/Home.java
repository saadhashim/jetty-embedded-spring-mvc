package com.sjl.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.util.log.Log;
import org.springframework.stereotype.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import beans.LoginBean;
import beans.ValvetBean;

@Controller
public class Home {

	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView model = new ModelAndView("index");
		LoginBean loginBean = new LoginBean();
		model.addObject("loginBean", loginBean);
		return model;
	}

	@RequestMapping(value = "/loggedin", method = RequestMethod.GET)
	public ModelAndView presentLoggedInSite() {
		ModelAndView model = new ModelAndView("loggedin");
		return model;
	}

	@RequestMapping(value = "/valvet", method = RequestMethod.GET)
	public ModelAndView presentValvet() {
		ModelAndView model = new ModelAndView("valvet");
		ValvetBean vb = new ValvetBean();
		vb.setNewValues();
		model.addObject("valvetBean", vb);
		return model;
	}

	@RequestMapping(value = "/oppnaValvet", method = RequestMethod.POST)
	public ModelAndView openValvetOrCallThePolice(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("valvetBean") ValvetBean valvetBean) {
		if (validateValvCode(valvetBean)) {
			return new ModelAndView("valvetopen");
		} else {
			return new ModelAndView("alarm");
		}
	}

	private boolean validateValvCode(ValvetBean vb) {
		boolean checkboxMatch = vb.getExpectedCheckbox().equalsIgnoreCase(vb.getChosenCheckbox());
		if (!checkboxMatch) {
			System.out.println("Checkbox " + vb.getExpectedCheckbox() + " " + vb.getChosenCheckbox());
		}
		boolean radioMatch = vb.getExpectedRadio().equalsIgnoreCase(vb.getChosenRadio());
		if (!radioMatch) {
			System.out.println("Radio missmatch " + vb.getExpectedRadio() + " " + vb.getChosenRadio());
		}
		boolean selectMatch = vb.getExpectedSelect().equalsIgnoreCase(vb.getChosenSelect());
		if (!selectMatch) {
			System.out.println("Select mismatch " + vb.getExpectedSelect() + " " + vb.getChosenSelect());
		}
		boolean textboxMatch = vb.getExpectedText().equalsIgnoreCase(vb.getTextboxValue());
		if (!textboxMatch) {
			System.out.println("Text Missmatch " + vb.getExpectedText() + " " + vb.getTextboxValue());
		}

		boolean forbiddenCheckboxMatch = vb.getChosenForbiddenCheckbox() == null;
		if (!forbiddenCheckboxMatch) {
			System.out.println("Forbidden checkbox Missmatch, was not null: " + vb.getChosenForbiddenCheckbox());
		}
		return checkboxMatch && radioMatch && selectMatch && textboxMatch && forbiddenCheckboxMatch;

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("loginBean") LoginBean loginBean) {
		ModelAndView model = null;
		try {

			boolean isValidUser = (loginBean.getUsername().equalsIgnoreCase("admin")
					&& loginBean.getPassword().equals("pwd"));

			if (isValidUser)

			{
				System.out.println("User Login Successful");
				request.setAttribute("loggedInUser", loginBean.getUsername());
				model = new ModelAndView("loggedin");
			} else {
				model = new ModelAndView("index");
				model.addObject("loginBean", loginBean);
				request.setAttribute("message", "Invalid credentials!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

}
