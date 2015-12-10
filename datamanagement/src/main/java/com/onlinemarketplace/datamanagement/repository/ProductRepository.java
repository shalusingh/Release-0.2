package com.onlinemarketplace.datamanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlinemarketplace.dataentity.domain.Product;
import com.onlinemarketplace.dataentity.domain.ProductCategory;
import com.onlinemarketplace.dataentity.domain.ProductSubCategory;
import com.onlinemarketplace.dataentity.enums.ProductStatus;

@Repository
@Transactional
public interface ProductRepository
    extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p JOIN p.productProperty pp WHERE pp.propertyName = :propertyName AND pp.propertyValue = :propertyValue")
    public Product getByProperyNameAndValue(@Param("propertyName") String propertyName,
        @Param("propertyValue") String propertyValue);

    @Query("SELECT p FROM Product p JOIN p.productProperty pp WHERE pp.propertyName = :propertyName AND pp.propertyValue = :propertyValue")
    public Product getByProperyName(@Param("propertyName") String propertyName,
        @Param("propertyValue") String propertyValue);

    @Query("SELECT p FROM Product p WHERE P.productCategory.id = :id AND p.status = 1")
    public List<Product> getByCategory(@Param("id") Long id);

    @Query("SELECT p FROM Product p WHERE p.status = :status")
    public List<Product> getByStatus(@Param("status") ProductStatus status);

    @Query("SELECT p FROM Product p WHERE p.status = 1 AND p.productCategory.categoryName = :categoryName")
    public List<Product> getByCategory(@Param("categoryName") String categoryName);

    @Query("SELECT p FROM Product p WHERE p.status = 1 AND p.productCode = :productCode")
    public Product getByCode(@Param("productCode") String productCode);

    @Query("SELECT p FROM Product p WHERE p.status = 1 AND p.productCategory = :productCategory")
    public List<Product> getByCategory(@Param("productCategory") ProductCategory productCategory);

    @Query("SELECT p FROM Product p WHERE p.status = 1 AND p.productSubCategory.id = :id")
    public List<Product> getBySubCategory(@Param("id") long id);

    @Query("SELECT p FROM Product p WHERE p.status = 1 AND p.productSubCategory.categoryName = :categoryName")
    public List<Product> getBySubCategory(@Param("categoryName") String categoryName);

    @Query("SELECT p FROM Product p WHERE p.status = 1 AND p.productSubCategory = :productSubCategory")
    public List<Product> getBySubCategory(@Param("productSubCategory") ProductSubCategory productSubCategory);

    @Query("SELECT p FROM Product p WHERE p.status = 1 AND p.id = :id")
    public List<Product> getById(@Param("id") long id);

    @Query("SELECT p FROM Product p WHERE p.status = 1 AND p.productCategory.id = :cid AND p.productSubCategory.id = :sid")
    public List<Product> getByCategoryAandSubCategory(@Param("cid") long cid, @Param("sid") long sid);

    @Query("SELECT p FROM Product p WHERE p.status = 1 AND p.productCategory.categoryName = :categoryName AND P.productSubCategory.categoryName = :subcategoryName")
    public List<Product> getByCategoryAandSubCategory(@Param("categoryName") String categoryName,
        @Param("subcategoryName") String subcategoryName);

    @Query("SELECT p FROM Product p WHERE p.status = 1 AND p.productCategory = :productCategory AND p.productSubCategory = :productSubCategory")
    public List<Product> getByCategoryAandSubCategory(@Param("productCategory") ProductCategory productCategory,
        @Param("productSubCategory") ProductSubCategory productSubCategory);

    @Query("SELECT p FROM Product p WHERE p.status = 1 AND p.name = :name")
    public List<Product> getByName(@Param("name") String name);

    @Query("SELECT p FROM Product p WHERE p.status = 1 AND p.productCode = :code")
    public List<Product> getBycode(@Param("code") String code);

    @Query("SELECT p FROM Product p WHERE p.status = 1 AND p.productCategory.id = :cid AND p.productSubCategory.id = :sid AND p.price >= :min AND p.price <= :max")
    public List<Product> getByCategoryAndSubCategoryAndPrice(@Param("cid") long cid, @Param("sid") long sid,
        @Param("min") float min, @Param("max") float max);

    @Query("SELECT p FROM Product p WHERE p.status = 1 AND p.price >= :min AND p.price <= :max")
    public List<Product> getByPrice(@Param("min") float min, @Param("max") float max);

    @Query("SELECT p FROM Product p WHERE p.status = 1 AND p.productCategory.categoryName = :categoryName AND p.productSubCategory.categoryName = :subcategoryName AND p.price >= :min AND p.price <= :max")
    public List<Product> getByCategoryAndSubCategoryAndPrice(@Param("categoryName") String categoryName,
        @Param("subcategoryName") String subcategoryName, @Param("min") float min, @Param("max") float max);

    @Query("SELECT p FROM Product p WHERE p.status = 1 AND p.productCategory = :productCategory AND p.productSubCategory = :productSubCategory AND p.price >= :min AND p.price <= :max")
    public List<Product> getByCategoryAndSubCategoryAndPrice(
        @Param("productCategory") ProductCategory productCategory,
        @Param("productSubCategory") ProductSubCategory productSubCategory, @Param("min") float min,
        @Param("max") float max);

    @Query("SELECT p FROM Product p WHERE p.status = 1 AND p.productCategory.id = :cid AND p.productSubCategory.id = :sid AND p.listingPrice >= :min AND p.price <= :max")
    public List<Product> getByCategoryAndSubCategoryAndLPrice(@Param("cid") long cid, @Param("sid") long sid,
        @Param("min") float min, @Param("max") float max);

    @Query("SELECT p FROM Product p WHERE p.status = 1 AND p.productCategory.categoryName = :categoryName AND p.productSubCategory.categoryName = :subcategoryName AND p.listingPrice >= :min AND p.price <= :max")
    public List<Product> getByCategoryAndSubCategoryAndLPrice(@Param("categoryName") String categoryName,
        @Param("subcategoryName") String subcategoryName, @Param("min") float min, @Param("max") float max);

    @Query("SELECT p FROM Product p WHERE p.status = 1 AND p.productCategory = :productCategory AND p.productSubCategory = :productSubCategory AND p.listingPrice >= :min AND p.price <= :max")
    public List<Product> getByCategoryAndSubCategoryAndLPrice(
        @Param("productCategory") ProductCategory productCategory,
        @Param("productSubCategory") ProductSubCategory productSubCategory, @Param("min") float min,
        @Param("max") float max);

    @Query("SELECT p FROM Product p WHERE p.status = 1 AND p.productCategory.id = :cid AND p.productSubCategory.id = :sid AND p.castPrice >= :min AND p.price <= :max")
    public List<Product> getByCategoryAndSubCategoryAndCPrice(@Param("cid") long cid, @Param("sid") long sid,
        @Param("min") float min, @Param("max") float max);

    @Query("SELECT p FROM Product p WHERE p.status = 1 AND p.productCategory.categoryName = :categoryName AND p.productSubCategory.categoryName = :subcategoryName AND p.castPrice >= :min AND p.price <= :max")
    public List<Product> getByCategoryAndSubCategoryAndCPrice(@Param("categoryName") String categoryName,
        @Param("subcategoryName") String subcategoryName, @Param("min") float min, @Param("max") float max);

    @Query("SELECT p FROM Product p WHERE p.status = 1 AND p.productCategory = :productCategory AND p.productSubCategory = :productSubCategory AND p.castPrice >= :min AND p.price <= :max")
    public List<Product> getByCategoryAndSubCategoryAndCPrice(
        @Param("productCategory") ProductCategory productCategory,
        @Param("productSubCategory") ProductSubCategory productSubCategory, @Param("min") float min,
        @Param("max") float max);

    @Query("SELECT p FROM Product p WHERE p.status = 1 AND p.name LIKE %:name%")
    public List<Product> likeName(@Param("name") String name);

    @Query("SELECT p FROM Product p WHERE p.status = 1 AND p.name LIKE %:name% AND p.productCategory.id = :id")
    public List<Product> getByCategory(@Param("name") String name, @Param("id") long id);

    @Query("SELECT p FROM Product p WHERE p.status = 1 AND p.name LIKE %:name% AND p.productCategory.categoryName = :categoryName")
    public List<Product> getByCategory(@Param("name") String name, @Param("categoryName") String categoryName);

    @Query("SELECT p FROM Product p WHERE p.status = 1 AND p.name LIKE %:name% AND p.productCategory = :productCategory")
    public List<Product> getByCategory(@Param("name") String name,
        @Param("productCategory") ProductCategory productCategory);

    @Query("SELECT p FROM Product p WHERE p.status = 1 AND p.name LIKE %:name% AND p.productSubCategory.id = :id")
    public List<Product> getBySubCategory(@Param("name") String name, @Param("id") long id);

    @Query("SELECT p FROM Product p WHERE p.status = 1 AND P.name LIKE %:name% AND p.productSubCategory.categoryName = :categoryName")
    public List<Product> getBySubCategory(@Param("name") String name, @Param("categoryName") String categoryName);

    @Query("SELECT p FROM Product p WHERE p.status = 1 AND p.name LIKE %:name% AND p.productSubCategory = :productSubCategory")
    public List<Product> getBySubCategory(@Param("name") String name,
        @Param("productSubCategory") ProductSubCategory productSubCategory);

    @Query("SELECT p FROM Product p WHERE p.status = 1 AND p.name LIKE %:name% AND p.productCategory.id = :cid AND p.productSubCategory.id = :sid")
    public List<Product> getByCategoryAandSubCategory(@Param("name") String name, @Param("cid") long cid,
        @Param("sid") long sid);

    @Query("SELECT p FROM Product p WHERE p.status = 1 AND p.name LIKE %:name% AND p.productCategory.categoryName = :categoryName AND p.productSubCategory.categoryName = :subcategoryName")
    public List<Product> getByCategoryAandSubCategory(@Param("name") String name,
        @Param("categoryName") String categoryName, @Param("subcategoryName") String subcategoryName);

    @Query("SELECT p FROM Product p WHERE p.status = 1 AND p.name LIKE %:name% AND p.productCategory = :productCategory AND p.productSubCategory = :productSubCategory")
    public List<Product> getByCategoryAandSubCategory(@Param("name") String name,
        @Param("productCategory") ProductCategory productCategory,
        @Param("productSubCategory") ProductSubCategory productSubCategory);

    @Query("SELECT p FROM Product p WHERE p.status = 1 AND p.name LIKE %:name% AND p.productCategory.id = :cid AND p.productSubCategory.id = :sid AND P.price BETWEEN :min AND :max")
    public List<Product> getByCategoryAndSubCategoryAndPrice(@Param("name") String name, @Param("cid") long cid,
        @Param("sid") long sid, @Param("min") float min, @Param("max") float max);

    @Query("SELECT p FROM Product p WHERE p.status = 1 AND p.name LIKE %:name% AND p.productCategory.categoryName = :categoryName AND p.productSubCategory.categoryName = :subcategoryName AND P.price BETWEEN :min AND :max")
    public List<Product> getByCategoryAndSubCategoryAndPrice(@Param("name") String name,
        @Param("categoryName") String categoryName, @Param("subcategoryName") String subcategoryName,
        @Param("min") float min, @Param("max") float max);

    @Query("SELECT p FROM Product p WHERE p.status = 1 AND p.name LIKE %:name% AND p.productCategory = :productCategory AND p.productSubCategory = :productSubCategory AND P.price BETWEEN :min AND :max")
    public List<Product> getByCategoryAndSubCategoryAndPrice(@Param("name") String name,
        @Param("productCategory") ProductCategory productCategory,
        @Param("productSubCategory") ProductSubCategory productSubCategory, @Param("min") float min,
        @Param("max") float max);

}
