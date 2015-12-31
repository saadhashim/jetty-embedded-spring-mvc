package com.sjl.web;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import com.sjl.BankRestClient;

import beans.CustomerBean;
import beans.TransactionBean;

@Controller
public class SecureBankingController {

	@RequestMapping(value = "/createcustomer", method = RequestMethod.GET)
	public ModelAndView presentCreateCustomerForm() {
		ModelAndView mv = new ModelAndView("createcustomer");
		mv.addObject("customerBean", new CustomerBean());
		return mv;
	}

	@RequestMapping(value = "/createcustomer", method = RequestMethod.POST)
	public ModelAndView createCustomer(@ModelAttribute("customerBean") CustomerBean customerBean,
			BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView("createcustomer");
		mv.addObject("info", BankRestClient.createCustomer(customerBean));
		return mv;
	}

	@RequestMapping(value = "/checkbalance", method = RequestMethod.GET)
	public ModelAndView presentCheckBalanceForm() {
		ModelAndView mv = new ModelAndView("checkbalance");
		mv.addObject("customerBean", new CustomerBean());
		return mv;
	}

	@RequestMapping(value = "/checkbalance", method = RequestMethod.POST)
	public ModelAndView checkBalance(@ModelAttribute("customerBean") CustomerBean customerBean,
			BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView("checkbalance");
		mv.addObject("info", BankRestClient.checkBalance(customerBean));
		return mv;
	}

	@RequestMapping(value = "/transaction", method = RequestMethod.GET)
	public ModelAndView presentTransactionForm() {
		ModelAndView mv = new ModelAndView("transaction");
		mv.addObject("transactionBean", new TransactionBean());
		return mv;
	}

	@RequestMapping(value = "/transaction", method = RequestMethod.POST)
	public ModelAndView transferMoney(@ModelAttribute("transactionBean") TransactionBean transcationBean,
			BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView("transaction");
		mv.addObject("transactionBean", new TransactionBean());
		if (transcationBean.getTransaction().equalsIgnoreCase("IN")) {
			mv.addObject("info", BankRestClient.insertMoney(transcationBean));
		} else if (transcationBean.getTransaction().equalsIgnoreCase("TA")) {
			mv.addObject("info", BankRestClient.withdrawMoney(transcationBean));
		} else {
			mv.addObject("info", transcationBean.getTransaction());
		}
		return mv;
	}

	@RequestMapping(value = "/allcustomers", method = RequestMethod.GET)
	public ModelAndView presentAllCustomersForm() {
		ModelAndView mv = new ModelAndView("allcustomers");
		mv.addObject("customers", BankRestClient.getAllCustomers());
		return mv;
	}

}
