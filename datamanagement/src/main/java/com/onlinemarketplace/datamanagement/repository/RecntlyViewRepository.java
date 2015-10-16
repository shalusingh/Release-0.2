package com.onlinemarketplace.datamanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlinemarketplace.dataentity.domain.RecntlyView;



@Repository
@Transactional
public interface RecntlyViewRepository extends JpaRepository< RecntlyView,Long> {
	
	@Query("SELECT rv FROM RecntlyView rv WHERE rv.customerId = :customerId")
	public List<RecntlyView> getByCustomerId(@Param("customerId") Long customerId);

}
