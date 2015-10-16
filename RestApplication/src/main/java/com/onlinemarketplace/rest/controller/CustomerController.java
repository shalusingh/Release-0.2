package com.onlinemarketplace.rest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onlinemarketplace.dataentity.domain.Customer;
import com.onlinemarketplace.datamanagement.repository.CustomerRepository;
import com.onlinemarketplace.rest.responce.CustomerResponce;
import com.onlinemarketplace.rest.responce.Response;

/**
 * 
 * @author jitndra.sagoriya
 * @version
 *
 */

@Controller
@RequestMapping("/user")
public class CustomerController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	CustomerRepository repository;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)	
	public @ResponseBody CustomerResponce login(HttpServletRequest request,HttpSession session){
		logger.info(">> login");
		CustomerResponce response = new CustomerResponce();
		String name = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		Customer customer = repository.getByUserNameAndPassword(name, pass);
		
		 
		if(customer!=null){
			response.setStatus(true);
			response.setResult(customer);
			response.setMessage("Welcome "+customer.getName() +", Happy to see you again.");
			
			// Setting customer to session
			logger.info(">> Setting customer to session");
			//session.setAttribute("customer", customer);
			
		}else {
			response.setStatus(false);
			response.setMessage("Your login cridential is not correct.Please enter correct user name and password.");
		}
		System.out.println( "Responce"+ response );
		return response;
	}  
	
	@RequestMapping(value="/sign",method=RequestMethod.POST)
	public @ResponseBody Response<Customer> sign(HttpRequest request ){
		logger.debug(">> login");
		Response<Customer> response = new Response<Customer>();
		
		return response;
	}
}
