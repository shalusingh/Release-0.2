package com.onlinemarketplace.datamanagement.serviceimpl.test;

import java.sql.Timestamp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.onlinemarketplace.dataentity.domain.Customer;
import com.onlinemarketplace.dataentity.enums.CustomerStatus;
import com.onlinemarketplace.datamanagement.config.DataManagementApplicationContext;
import com.onlinemarketplace.datamanagement.repository.CustomerRepository;

@ContextConfiguration(classes={DataManagementApplicationContext.class})
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerServiceImplTest {

	@Autowired CustomerRepository customerRepository;
	
	
	public Customer getCustomer(){
		Customer customer = new Customer();
		customer.setCountry("INDIA");
		customer.setEmail("monika.gupta@cmc.com");
		customer.setLandLineNumber("23569856");
		customer.setPassword("123456");
		customer.setMobileNumber("09987321404");
		customer.setName("Monika Gupta");
		customer.setOrganization("CMC LTD");
		customer.setPassword("123456");
		customer.setPhoneNumber("09656989696");
		customer.setRegistrationDate(new Timestamp(System.currentTimeMillis() ) );
		customer.setStatus(CustomerStatus.ACTIVE);
		return customer;
	}
	
	@Test
    public void testFindByFirstName() {
		Customer customer = new Customer();
		customerRepository.save(getCustomer());
		customer = customerRepository.getByEmail("monika.gupta@cmc.com");
		Assert.assertEquals("Monika Gupta", customer.getName() );;
        
    }
	
	@Test
    public void testFindByEmailAndPassword() {
		Customer customer = getCustomer();
		customer.setEmail("monika.gupta1@cmc.com");
		customerRepository.save(customer);
		Customer customer1 = customerRepository.getByUserNameAndPassword("monika.gupta1@cmc.com", "123456");
		Assert.assertEquals("Monika Gupta", customer1.getName() );;
		Assert.assertNotNull(customer1.getCustomerId() );
        
    }
}
