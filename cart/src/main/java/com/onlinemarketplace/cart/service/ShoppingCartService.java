package com.onlinemarketplace.cart.service;

import org.springframework.stereotype.Service;

import com.onlinemarketplace.cart.exception.CartNotFoundException;
import com.onlinemarketplace.dataentity.domain.Cart;
import com.onlinemarketplace.dataentity.domain.CartItem;
import com.onlinemarketplace.datamanagement.repository.CustomerRepository;
import com.onlinemarketplace.datamanagement.service.CartService;
 

@Service
public interface ShoppingCartService { 
	
	
	
	public void setCartService(CartService cartService);
	public void setCustomerRepository(CustomerRepository customerRepository) ;
	
	public boolean add(CartItem cartItem);
	public boolean remove(CartItem cartItem) throws CartNotFoundException;
	
		
	public Cart get(Long id);
	public boolean delete(Cart cart) throws CartNotFoundException;
	public int getCount();
	public Float getTotalCost() throws CartNotFoundException;
	public Float getDiscount() throws CartNotFoundException;
	public Boolean put(Cart cart);
	public Cart create(Long customer);

	
}
