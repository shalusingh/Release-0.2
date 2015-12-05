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

    @Query("SELECT p FROM Product p WHERE P.productCategory = :id")
    public List<Product> getByCategory(@Param("id") Long id);

    @Query("SELECT p FROM Product p WHERE P.productCategory = :productCategory")
    public List<Product> getByCategory(@Param("productCategory") ProductCategory productCategory);

    @Query("SELECT p FROM Product p WHERE P.productSubCategory = :id")
    public List<Product> getBySubCategory(@Param("id") long id);

    @Query("SELECT p FROM Product p WHERE P.productSubCategory = :productSubCategory")
    public List<Product> getBySubCategory(@Param("productSubCategory") ProductSubCategory productSubCategory);

    @Query("SELECT p FROM Product p WHERE P.id = :id")
    public List<Product> getById(@Param("id") long id);

    @Query("SELECT p FROM Product p WHERE P.productCategory.id = :cid AND P.productSubCategory = :sid")
    public List<Product> getByCategoryAandSubCategory(@Param("cid") long cid, @Param("sid") long sid);

    @Query("SELECT p FROM Product p WHERE P.productCategory = :productCategory AND P.productSubCategory = :productSubCategory")
    public List<Product> getByCategoryAandSubCategory(@Param("productCategory") ProductCategory productCategory,
        @Param("productSubCategory") ProductSubCategory productSubCategory);

    @Query("SELECT p FROM Product p WHERE P.name = :name")
    public List<Product> getByName(@Param("name") String name);

    @Query("SELECT p FROM Product p WHERE P.productCode = :code")
    public List<Product> getBycode(@Param("code") String code);

    @Query("SELECT p FROM Product p WHERE P.productCategory = :cid AND P.productSubCategory = :sid AND p.price >= :min AND p.price <= :max")
    public List<Product> getByCategoryAndSubCategoryAndPrice(@Param("cid") long cid, @Param("sid") long sid,
        @Param("min") float min, @Param("max") float max);

    @Query("SELECT p FROM Product p WHERE P.productCategory = :productCategory AND P.productSubCategory = :productSubCategory AND p.price >= :min AND p.price <= :max")
    public List<Product> getByCategoryAndSubCategoryAndPrice(
        @Param("productCategory") ProductCategory productCategory,
        @Param("productSubCategory") ProductSubCategory productSubCategory, @Param("min") float min,
        @Param("max") float max);

    @Query("SELECT p FROM Product p WHERE P.productCategory = :cid AND P.productSubCategory = :sid AND p.listingPrice >= :min AND p.price <= :max")
    public List<Product> getByCategoryAndSubCategoryAndLPrice(@Param("cid") long cid, @Param("sid") long sid,
        @Param("min") float min, @Param("max") float max);

    @Query("SELECT p FROM Product p WHERE P.productCategory = :productCategory AND P.productSubCategory = :productSubCategory AND p.listingPrice >= :min AND p.price <= :max")
    public List<Product> getByCategoryAndSubCategoryAndLPrice(
        @Param("productCategory") ProductCategory productCategory,
        @Param("productSubCategory") ProductSubCategory productSubCategory, @Param("min") float min,
        @Param("max") float max);

    @Query("SELECT p FROM Product p WHERE P.productCategory = :cid AND P.productSubCategory = :sid AND p.castPrice >= :min AND p.price <= :max")
    public List<Product> getByCategoryAndSubCategoryAndCPrice(@Param("cid") long cid, @Param("sid") long sid,
        @Param("min") float min, @Param("max") float max);

    @Query("SELECT p FROM Product p WHERE P.productCategory = :productCategory AND P.productSubCategory = :productSubCategory AND p.castPrice >= :min AND p.price <= :max")
    public List<Product> getByCategoryAndSubCategoryAndCPrice(
        @Param("productCategory") ProductCategory productCategory,
        @Param("productSubCategory") ProductSubCategory productSubCategory, @Param("min") float min,
        @Param("max") float max);

    @Query("SELECT p FROM Product p WHERE P.name LIKE %:name%")
    public List<Product> likeName(@Param("name") String name);

    @Query("SELECT p FROM Product p WHERE P.name LIKE %:name% AND P.productCategory = :id")
    public List<Product> getByCategory(@Param("name") String name, @Param("id") long id);

    @Query("SELECT p FROM Product p WHERE P.name LIKE %:name% AND P.productCategory = :productCategory")
    public List<Product> getByCategory(@Param("name") String name,
        @Param("productCategory") ProductCategory productCategory);

    @Query("SELECT p FROM Product p WHERE P.name LIKE %:name% AND P.productSubCategory = :id")
    public List<Product> getBySubCategory(@Param("name") String name, @Param("id") long id);

    @Query("SELECT p FROM Product p WHERE P.name LIKE %:name% AND P.productSubCategory = :productSubCategory")
    public List<Product> getBySubCategory(@Param("name") String name,
        @Param("productSubCategory") ProductSubCategory productSubCategory);

    @Query("SELECT p FROM Product p WHERE P.name LIKE %:name% AND P.productCategory = :cid AND P.productSubCategory = :sid")
    public List<Product> getByCategoryAandSubCategory(@Param("name") String name, @Param("cid") long cid,
        @Param("sid") long sid);

    @Query("SELECT p FROM Product p WHERE P.name LIKE %:name% AND P.productCategory = :productCategory AND P.productSubCategory = :productSubCategory")
    public List<Product> getByCategoryAandSubCategory(@Param("name") String name,
        @Param("productCategory") ProductCategory productCategory,
        @Param("productSubCategory") ProductSubCategory productSubCategory);

    @Query("SELECT p FROM Product p WHERE P.name LIKE %:name% AND P.productCategory = :cid AND P.productSubCategory = :sid AND P.price BETWEEN :min AND :max")
    public List<Product> getByCategoryAndSubCategoryAndPrice(@Param("name") String name, @Param("cid") long cid,
        @Param("sid") long sid, @Param("min") float min, @Param("max") float max);

    @Query("SELECT p FROM Product p WHERE P.name LIKE %:name% AND P.productCategory = :productCategory AND P.productSubCategory = :productSubCategory AND P.price BETWEEN :min AND :max")
    public List<Product> getByCategoryAndSubCategoryAndPrice(@Param("name") String name,
        @Param("productCategory") ProductCategory productCategory,
        @Param("productSubCategory") ProductSubCategory productSubCategory, @Param("min") float min,
        @Param("max") float max);

}
