package com.onlinemarketplace.datamanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlinemarketplace.dataentity.domain.ProductCategory;

@Repository
@Transactional
public interface ProductCategoryRepository
    extends JpaRepository<ProductCategory, Long> {

    @Query("FROM ProductCategory pc WHERE pc.status = 1 AND pc.categoryName = :categoryName")
    public ProductCategory getByName(@Param("categoryName") String name);

    @Query("FROM ProductCategory pc WHERE pc.status = 1 AND pc.id = :id")
    public ProductCategory getById(@Param("id") Long id);

}
