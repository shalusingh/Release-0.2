package com.onlinemarketplace.datamanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlinemarketplace.dataentity.domain.Order;


@Repository
@Transactional
public interface OrderReopsitory extends JpaRepository< Order,Long> {

	@Query("SELECT o FROM Order o WHERE o.customerId = :customerId")
	public List<Order> getOrderByCustomerId(@Param(value = "customerId") Long customerId);
}
