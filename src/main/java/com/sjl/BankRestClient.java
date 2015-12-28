package com.sjl;

import java.util.ArrayList;
import java.util.List;

import beans.CustomerBean;
import beans.TransactionBean;

public class BankRestClient {
	
	public static boolean createCustomer(CustomerBean customer){
		if(customer == null){
			return false;
		}
		
		if(customer.getName().equalsIgnoreCase("saad")){
			return true;
		}
		
		return false;
	}
	
	public static String checkBalance(CustomerBean customer){
		if(customer == null){
			throw new IllegalArgumentException("Customer is null");
		}
		return "100.3";
	}
	
	public static boolean insertMoney(TransactionBean transaction){
		if(transaction == null){
			throw new IllegalArgumentException("Customer is null");
		}
		if(Float.valueOf(transaction.getAmount()) <=0){
			return false;
		}
		return true;
	}
	
	public static boolean withdrawMoney(TransactionBean transaction){
		if(transaction == null){
			throw new IllegalArgumentException("Customer is null");
		}
		if(Float.valueOf(transaction.getAmount()) <=0){
			return false;
		}
		return true;
	}
	
	public static List<CustomerBean> getAllCustomers(){
		List<CustomerBean> customers = new ArrayList<CustomerBean>();
		customers.add(new CustomerBean("saad", "100.5"));
		customers.add(new CustomerBean("saad1", "10440.5"));
		customers.add(new CustomerBean("saad2", "1003.5"));
		return customers;
	}

}
