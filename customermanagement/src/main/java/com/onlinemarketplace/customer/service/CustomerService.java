package com.onlinemarketplace.customer.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.onlinemarketplace.customer.helper.Helper;
import com.onlinemarketplace.dataentity.domain.Customer;
import com.onlinemarketplace.dataentity.domain.Order;
import com.onlinemarketplace.datamanagement.repository.CustomerRepository;
import com.onlinemarketplace.datamanagement.service.OrderService;
import com.onlinemarketplace.exception.FieldNotFoundException;

@Service
public class CustomerService {

	/**
	 * Object of CustomerRepsitory.
	 * */
	com.onlinemarketplace.datamanagement.service.CustomerService service;
	
	OrderService orderService;

	/**
	 *Setter for Customer repository.
	 *@param repository : {@link CustomerRepository} 
	 */
	public void setRepository(com.onlinemarketplace.datamanagement.service.CustomerService service) {
		this.service = service;
	}
	
	
	/**
	 * Get Customer by customer Id.
	 * @param customerId : Long
	 * 
	 * @return Customer : [{@link Customer})]
	 */
	public Customer getCustomer(Long customerId){
		return service.getRepository().getOne(customerId);
	}
	
	/**
	 * Registor new customer in database.
	 * @param request : {@link HttpServletRequest}
	 * 
	 * @return object of customer :{@link Customer}
	 */
	public Customer registor(HttpServletRequest request) throws FieldNotFoundException {
		return service.getRepository().save( Helper.getCustomerByRequest(request) );
	}
	
	/**
	 * Get all previous successfull order.
	 * @param customerId : Long
	 * 
	 * @return List of order : List<{@link Order}>
	 */
	public List<Order> getOrder(Long customerId){
		List<Order> orders = null;
		orders = orderService.getReopsitory().getOrderByCustomerId(customerId);
		return orders;
	}
	
	/**
	 * Change password.
	 * @param customer : {@link Customer}
	 * 
	 * @return customer : {@link Customer}
	 */
	public Customer changePassword(Customer customer){
		return service.getRepository().saveAndFlush(customer);
	}
	
}
