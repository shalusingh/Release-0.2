package com.onlinemarketplace.datamanagement.serviceimpl.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.onlinemarketplace.dataentity.domain.Cart;
import com.onlinemarketplace.dataentity.domain.CartItem;
import com.onlinemarketplace.dataentity.enums.CartStatus;
import com.onlinemarketplace.dataentity.enums.Priority;
import com.onlinemarketplace.datamanagement.config.DataManagementApplicationContext;
import com.onlinemarketplace.datamanagement.service.CartService;
import com.onlinemarketplace.datamanagement.service.ProductService;

@ContextConfiguration(classes={DataManagementApplicationContext.class})
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class CartImplTest {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private ProductService productService;
	
	@Test
	public void insertCart(){
		Cart cart = new Cart();
		cart.setStatus(CartStatus.VERIFY);
		cart.setPriority(Priority.ONE);
		cart.setCustomerId(1L);
		cart.setjSessionId("KLDOKFHJDIHKKKHKF1236FJ");
		
		List<CartItem> cartItems = new ArrayList<CartItem>();
		CartItem cartItem = new CartItem();
		cartItem.setCart(cart);
		cartItem.setProduct(productService.getRepository().findOne(1L));
		cartItem.setCount(1);
		
		cartItems.add(cartItem);
		
		cart.setItems(cartItems);
		
		cartService.getRepository().save(cart);
	}

}
