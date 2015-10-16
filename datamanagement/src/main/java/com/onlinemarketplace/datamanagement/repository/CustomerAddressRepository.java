package com.onlinemarketplace.datamanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlinemarketplace.dataentity.domain.Customer;
import com.onlinemarketplace.dataentity.domain.CustomerAddress;


@Repository
@Transactional
public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Long> {
	
	@Query("SELECT ca FROM CustomerAddress ca WHERE ca.customer = :customerId")
	public List<CustomerAddress> getByCustomerId(@Param("customerId") Customer  customer);
	
}
