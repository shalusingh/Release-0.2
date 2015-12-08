/**
 *
 */
package com.onlinemarketplace.dto.domain;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * @author jitendra Dec 7, 2015 2015
 */
public class ProductDto
    extends BaseDto {

    /**
     *
     */
    private static final long serialVersionUID = -2237921997550217790L;

    private String productCode;

    private CategoryDto category;

    private SubCategoryDto subCategory;

    private SubSubCategoryDto subSubCategory;

    private Float listingPrice;

    private Float castPrice;

    private int priority;

    private boolean preOrderStatus;

    private Timestamp availableDate;

    private Float price;

    private Integer quantity;

    private Map<String, String> property;

    private List<OfferDto> offer;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public SubCategoryDto getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategoryDto subCategory) {
        this.subCategory = subCategory;
    }

    public SubSubCategoryDto getSubSubCategory() {
        return subSubCategory;
    }

    public void setSubSubCategory(SubSubCategoryDto subSubCategory) {
        this.subSubCategory = subSubCategory;
    }

    public Float getListingPrice() {
        return listingPrice;
    }

    public void setListingPrice(Float listingPrice) {
        this.listingPrice = listingPrice;
    }

    public Float getCastPrice() {
        return castPrice;
    }

    public void setCastPrice(Float castPrice) {
        this.castPrice = castPrice;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isPreOrderStatus() {
        return preOrderStatus;
    }

    public void setPreOrderStatus(boolean preOrderStatus) {
        this.preOrderStatus = preOrderStatus;
    }

    public Timestamp getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(Timestamp availableDate) {
        this.availableDate = availableDate;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Map<String, String> getProperty() {
        return property;
    }

    public void setProperty(Map<String, String> property) {
        this.property = property;
    }

    public List<OfferDto> getOffer() {
        return offer;
    }

    public void setOffer(List<OfferDto> offer) {
        this.offer = offer;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();

        result = prime
            * result
            + ((productCode == null)
                ? 0 : productCode.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProductDto other = (ProductDto) obj;

        if (productCode == null) {
            if (other.productCode != null)
                return false;
        } else
            if (!other.productCode.equalsIgnoreCase(productCode))
                return false;

        return true;
    }

    @Override
    public String toString() {
        return "ProductDto [productCode="
            + productCode + ", category=" + category + ", subCategory=" + subCategory + ", subSubCategory="
            + subSubCategory + ", listingPrice=" + listingPrice + ", castPrice=" + castPrice + ", priority="
            + priority + ", preOrderStatus=" + preOrderStatus + ", availableDate=" + availableDate + ", price="
            + price + ", quantity=" + quantity + ", property=" + property + ", offer=" + offer + ", getId()="
            + getId() + ", getName()=" + getName() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
            + "]";
    }

}
