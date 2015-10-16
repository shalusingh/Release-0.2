package com.onlinemarketplace.datamanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlinemarketplace.dataentity.domain.Customer;

@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	@Query("SELECT c FROM Customer c WHERE c.email = :email")
	public Customer getByEmail(@Param("email") String email);
	
	@Query("SELECT c FROM Customer c WHERE c.email = :email AND c.password = :password")
	public Customer getByUserNameAndPassword(@Param("email") String username,@Param("password") String password);

}
