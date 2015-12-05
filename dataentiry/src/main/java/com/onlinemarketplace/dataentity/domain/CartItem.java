package com.onlinemarketplace.dataentity.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.onlinemarketplace.dataentity.base.NaturalAbstractEntity;

/**
 * @author jiendra sagoriya
 */

@Entity
@Table(name = "cartitem")
public class CartItem
    extends NaturalAbstractEntity<Long>
    implements Serializable {

    private static final long serialVersionUID = 1L;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Product product;

    @Column(name = "count")
    private int count;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Cart cart;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime
            * result
            + ((cart == null)
                ? 0 : cart.hashCode());
        result = prime
            * result
            + count;
        result = prime
            * result
            + ((product == null)
                ? 0 : product.hashCode());
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
        CartItem other = (CartItem) obj;
        if (cart == null) {
            if (other.cart != null)
                return false;
        } else
            if (!cart.equals(other.cart))
                return false;
        if (count != other.count)
            return false;
        if (product == null) {
            if (other.product != null)
                return false;
        } else
            if (!product.equals(other.product))
                return false;
        return true;
    }

    @Override
    public String toString() {
        return "CartItem [product="
            + product + ", count=" + count + ", cart=" + cart + "]";
    }

}
