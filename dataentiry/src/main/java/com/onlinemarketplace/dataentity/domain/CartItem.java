package com.onlinemarketplace.dataentity.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.onlinemarketplace.dataentity.base.AbstractEntity;


/**
 * @author jiendra sagoriya 
 */

@Entity
@Table(name="cartitem")
public class CartItem extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
    private Product product;
	
	@Column(name="count")
	private int count;
	
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY,optional=false)
	private Cart cart;
	

	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}


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
		result = prime * result + ((cart == null) ? 0 : cart.hashCode());
		result = prime * result + count;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		} else if (!cart.equals(other.cart))
			return false;
		if (count != other.count)
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "CartItem [product=" + product + ", count=" + count + ", cart=" + cart + ", getId()=" + getId()
				+ ", getCreationDate()=" + getCreationDate() + ", getPriority()=" + getPriority()
				+ ", getExtraField1()=" + getExtraField1() + ", getExtraField2()=" + getExtraField2()
				+ ", getExtraField3()=" + getExtraField3() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + "]";
	}


	 

	 
}
