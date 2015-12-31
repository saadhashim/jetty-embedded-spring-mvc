package com.sjl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import beans.CustomerBean;
import beans.TransactionBean;
import java.io.IOException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class BankRestClient {

	public static JSONObject getRestResponse(String path, boolean get, String... queryStrings)
			throws ClientProtocolException, IOException {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(UriBuilder.fromUri("http://localhost:8081/jstabanken-rest-api/").build());
		MultivaluedMap<String, String> queryStrs = new MultivaluedMapImpl();

		if (queryStrings != null && queryStrings.length > 0) {
			for (String str : queryStrings) {
				queryStrs.add(str.split("=")[0], str.split("=")[1]);
			}
		}
		String response;
		try {
			if(get){
				response = service.path(path).queryParams(queryStrs).accept(MediaType.APPLICATION_JSON).get(String.class);
			}else{
				response = service.path(path).queryParams(queryStrs).accept(MediaType.APPLICATION_JSON).post(String.class);
			}
			System.out.println(response);
			JSONObject obj = new JSONObject(response);
			return obj;
		} catch (Exception e) {
			return new JSONObject("{error:404}");
		}

	}

	public static String createCustomer(CustomerBean customer) {
		if (customer == null) {
			return "Kunden är null";
		}

		
		JSONObject obj;
		try {
			obj = getRestResponse("jstabanken/createcustomer", false, "name=" + customer.getName());
			String saldo = obj.getString("Balance");
			String name = obj.getString("Name");
			return "Kund med namn " + name + " skapades med saldo " + saldo;
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}catch(Exception e){
			
		}

		return "Kund finns redan";
	}

	public static String checkBalance(CustomerBean customer) {
		if (customer == null) {
			throw new IllegalArgumentException("Customer is null");
		}
		try {
			JSONObject obj = getRestResponse("jstabanken/getbalance", true, "name=" + customer.getName());
			try {
				return obj.getString("Balance");
			} catch (Exception e) {
				return "Kund finns inte";
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();

		}
	}

	public static String insertMoney(TransactionBean transaction) {
		if (transaction == null) {
			throw new IllegalArgumentException("Customer is null");
		}
		if (Float.valueOf(transaction.getAmount()) <= 0) {
			return "Belopp måste vara större än noll";
		}
		
		try {
			JSONObject obj = getRestResponse("jstabanken/insertmoney", false, "name=" + transaction.getName(), "amount=" + transaction.getAmount());
			String saldo = obj.getString("Balance");
			String name = obj.getString("Name");

			return name + " har nu: "+ saldo + " kr på kontot";
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();

		}catch(Exception e){
			
		}
		return "Kund finns inte";
	}

	public static String withdrawMoney(TransactionBean transaction) {
		if (transaction == null) {
			throw new IllegalArgumentException("Customer is null");
		}
		if (Float.valueOf(transaction.getAmount()) <= 0) {
			return "Belopp måste vara större än noll";
		}
		
		String balance = checkBalance(new CustomerBean(transaction.getName(), "0"));
		try{
			float balanceInFloat = Float.valueOf(balance);
			if(balanceInFloat - Float.valueOf(transaction.getAmount()) <0){
				return "Det finns för lite pengar";
			}
		}catch(Exception e){
			return "Kund finns inte";
		}

		
		try {
			JSONObject obj = getRestResponse("jstabanken/withdrawmoney", false, "name=" + transaction.getName(), "amount=" + transaction.getAmount());
			String saldo = obj.getString("Balance");
			String name = obj.getString("Name");

			return name + " har nu: "+ saldo + " kr på kontot";
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();

		}catch(Exception e){
			
		}
		return "Kund finns inte";
	}

	public static List<CustomerBean> getAllCustomers() {
		List<CustomerBean> customers = new ArrayList<CustomerBean>();
		try {
			JSONObject obj = getRestResponse("jstabanken/getcustomers", true);
			JSONArray arr = obj.getJSONArray("customers");
			for (int i = 0; i < arr.length(); i++) {
				String name = arr.getJSONObject(i).getString("name");
				String balance = arr.getJSONObject(i).getString("Balance");
				customers.add(new CustomerBean(name, balance));
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customers;
	}

}
