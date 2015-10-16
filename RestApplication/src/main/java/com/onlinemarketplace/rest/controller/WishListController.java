package com.onlinemarketplace.rest.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.onlinemarketplace.dataentity.domain.Customer;
import com.onlinemarketplace.dataentity.domain.WishList;
import com.onlinemarketplace.datamanagement.repository.WishListRepository;
import com.onlinemarketplace.rest.responce.Response;

@Controller
@RequestMapping("/wishlist")
public class WishListController {

	@Autowired
	WishListRepository repository;
	
	
	@RequestMapping(value="/" ,method=RequestMethod.GET)
	public Response<WishList> getWishList( HttpSession session){
		Response<WishList> response = new Response<WishList>();
		Customer customer = null;
		if(session.getAttribute("customer") == null){
			response.setStatus(false);
			response.setMessage("Invalid request/User not logged In."); 
			return response;
		}else{
			customer = (Customer) session.getAttribute("customer");
		}
			
		try{
			List<WishList> wishLists = repository.findByCustomer(customer.getCustomerId() );
			response.setStatus(true);
			response.setResult(wishLists);
			response.setMessage("Successfully get wishlist");
		}catch(Exception exception){
			response.setStatus(false);
			response.setException(exception);
		}
		return response;
	}
	
	
	@RequestMapping(value="/add/{productId}",method=RequestMethod.POST)
	public Response<WishList> addWishList(@RequestParam("productId") long productId, HttpServletRequest request ,HttpSession session){
		Response<WishList> response = new Response<WishList>();
		WishList wishList = null;
		Customer customer = (Customer)session.getAttribute("customer");
		if(customer == null){
			response.setStatus(false);
			response.setMessage("User is not login or Invalid user.");
			
			return response;
		}
		
		wishList = new WishList();
		wishList.setDate(new Timestamp(System.currentTimeMillis()));
		wishList.setProductId(productId);
		wishList.setCustomerId(customer.getCustomerId());
		
		try{
			wishList = repository.save(wishList);
			response.setResult(wishList);
			response.setStatus(true);
			
		}catch(Exception exception){
			response.setStatus(false);
			response.setMessage("Unable to add this product into wishlist.Please try again after some time.");
			response.setException(exception);
		}
		return null;
		
	}
	
}
