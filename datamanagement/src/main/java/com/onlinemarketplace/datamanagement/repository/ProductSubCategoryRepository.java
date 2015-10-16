package com.onlinemarketplace.datamanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlinemarketplace.dataentity.domain.ProductSubCategory;


@Repository
@Transactional
public interface ProductSubCategoryRepository extends JpaRepository< ProductSubCategory,Long> {
	
	@Query("SELECT pc FROM ProductSubCategory pc WHERE pc.categoryName = :categoryName")
	public ProductSubCategory getByName(@Param("categoryName") String name);
	
}
