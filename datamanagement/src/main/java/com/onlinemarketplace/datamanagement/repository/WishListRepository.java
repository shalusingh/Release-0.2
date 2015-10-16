package com.onlinemarketplace.datamanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlinemarketplace.dataentity.domain.WishList;


@Repository
@Transactional
public interface WishListRepository extends JpaRepository< WishList,Long> {

	
	@Query("SELECT w FROM WishList w WHERE w.customerId = :id")
	public List<WishList> findByCustomer(@Param(value = "id") Long customerIs);
}
