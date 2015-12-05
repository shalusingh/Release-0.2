package com.onlinemarketplace.dataentity.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.onlinemarketplace.dataentity.base.StateFullNaturalEntity;
import com.onlinemarketplace.dataentity.enums.Priority;
import com.onlinemarketplace.dataentity.enums.ProductStatus;

/**
 * @author jitendra.sagoriya
 * @version $Revision: $($Date: $)
 */
@Entity
@Table(name = "product")
@NamedQueries({
    @NamedQuery(name = "Product.All", query = "select p from Product p"), @NamedQuery(name = "Product.All.Join",
        query = "SELECT p FROM Product p JOIN p.productProperty pp")

})
public class Product
    extends StateFullNaturalEntity<ProductStatus, Long>
    implements Serializable {

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(Product.class);

    private static final long serialVersionUID = -3631511217242256987L;

    @Column(length = 12, unique = true)
    private String productCode;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private ProductCategory productCategory;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private ProductSubCategory productSubCategory;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, optional = true)
    private SubSubCategory subSubCategory;

    @Column(nullable = false)
    private Float listingPrice;

    @Column(nullable = false)
    private Float castPrice;

    @Column
    private Priority productPriority;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private boolean preOrderStatus;

    @Column(nullable = true)
    private Timestamp availableDate;

    @Column(nullable = false)
    private Float price;

    @Column(nullable = false)
    private Integer quantity;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProductProperty> productProperty;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "product", fetch = FetchType.LAZY)
    private List<Offer> offer;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
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

    public Priority getProductPriority() {
        return productPriority;
    }

    public void setProductPriority(Priority productPriority) {
        this.productPriority = productPriority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<ProductProperty> getProductProperty() {
        return productProperty;
    }

    public void setProductProperty(List<ProductProperty> productProperty) {
        this.productProperty = productProperty;
    }

    public List<Offer> getOffer() {
        return offer;
    }

    public void setOffer(List<Offer> offer) {
        this.offer = offer;
    }

    @Override
    public String toString() {
        return "Product [productCode="
            + productCode + ", productCategory=" + productCategory + ", productSubCategory=" + productSubCategory
            + ", subSubCategory=" + subSubCategory + ", listingPrice=" + listingPrice + ", castPrice=" + castPrice
            + ", productPriority=" + productPriority + ", name=" + name + ", preOrderStatus=" + preOrderStatus
            + ", availableDate=" + availableDate + ", price=" + price + ", quantity=" + quantity
            + ", productProperty=" + productProperty + ", offer=" + offer + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime
            * result
            + ((availableDate == null)
                ? 0 : availableDate.hashCode());
        result = prime
            * result
            + ((castPrice == null)
                ? 0 : castPrice.hashCode());
        result = prime
            * result
            + ((listingPrice == null)
                ? 0 : listingPrice.hashCode());
        result = prime
            * result
            + ((name == null)
                ? 0 : name.hashCode());
        result = prime
            * result
            + ((offer == null)
                ? 0 : offer.hashCode());
        result = prime
            * result
            + (preOrderStatus
                ? 1231 : 1237);
        result = prime
            * result
            + ((price == null)
                ? 0 : price.hashCode());
        result = prime
            * result
            + ((productCategory == null)
                ? 0 : productCategory.hashCode());
        result = prime
            * result
            + ((productCode == null)
                ? 0 : productCode.hashCode());
        result = prime
            * result
            + ((productPriority == null)
                ? 0 : productPriority.hashCode());
        result = prime
            * result
            + ((productProperty == null)
                ? 0 : productProperty.hashCode());
        result = prime
            * result
            + ((productSubCategory == null)
                ? 0 : productSubCategory.hashCode());
        result = prime
            * result
            + ((quantity == null)
                ? 0 : quantity.hashCode());
        result = prime
            * result
            + ((subSubCategory == null)
                ? 0 : subSubCategory.hashCode());
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
        Product other = (Product) obj;
        if (availableDate == null) {
            if (other.availableDate != null)
                return false;
        } else
            if (!availableDate.equals(other.availableDate))
                return false;
        if (castPrice == null) {
            if (other.castPrice != null)
                return false;
        } else
            if (!castPrice.equals(other.castPrice))
                return false;
        if (listingPrice == null) {
            if (other.listingPrice != null)
                return false;
        } else
            if (!listingPrice.equals(other.listingPrice))
                return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else
            if (!name.equals(other.name))
                return false;
        if (offer == null) {
            if (other.offer != null)
                return false;
        } else
            if (!offer.equals(other.offer))
                return false;
        if (preOrderStatus != other.preOrderStatus)
            return false;
        if (price == null) {
            if (other.price != null)
                return false;
        } else
            if (!price.equals(other.price))
                return false;
        if (productCategory == null) {
            if (other.productCategory != null)
                return false;
        } else
            if (!productCategory.equals(other.productCategory))
                return false;
        if (productCode == null) {
            if (other.productCode != null)
                return false;
        } else
            if (!productCode.equals(other.productCode))
                return false;
        if (productPriority != other.productPriority)
            return false;
        if (productProperty == null) {
            if (other.productProperty != null)
                return false;
        } else
            if (!productProperty.equals(other.productProperty))
                return false;
        if (productSubCategory == null) {
            if (other.productSubCategory != null)
                return false;
        } else
            if (!productSubCategory.equals(other.productSubCategory))
                return false;
        if (quantity == null) {
            if (other.quantity != null)
                return false;
        } else
            if (!quantity.equals(other.quantity))
                return false;
        if (subSubCategory == null) {
            if (other.subSubCategory != null)
                return false;
        } else
            if (!subSubCategory.equals(other.subSubCategory))
                return false;
        return true;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public ProductSubCategory getProductSubCategory() {
        return productSubCategory;
    }

    public void setProductSubCategory(ProductSubCategory productSubCategory) {
        this.productSubCategory = productSubCategory;
    }

    public SubSubCategory getSubSubCategory() {
        return subSubCategory;
    }

    public void setSubSubCategory(SubSubCategory subSubCategory) {
        this.subSubCategory = subSubCategory;
    }

    public static Map<Long, Product> getProductMap(List<Product> products) {
        Map<Long, Product> productMap = new Hashtable<Long, Product>();
        if (products != null) {
            for (Product product : products) {
                if (product != null) {
                    productMap.put(product.getId(), product);
                }
            }
        }
        return productMap;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.onlinemarketplace.dataentity.base.StateFullNaturalEntity#getStatus()
     */
    @Override
    public ProductStatus getStatus() {
        // TODO Auto-generated method stub
        return super.status;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.onlinemarketplace.dataentity.base.StateFullNaturalEntity#setStatus(java.lang.Object)
     */
    @Override
    public void setStatus(ProductStatus status) {
        super.status = status;

    }

}
