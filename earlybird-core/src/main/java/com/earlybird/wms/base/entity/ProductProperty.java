/**
 * 
 */
package com.earlybird.wms.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Some products may have properties like color, batch etc. 
 * @author Peili Zhou
 *
 */
@Entity
public class ProductProperty extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4971505048099795526L;
	@Column
	protected String value;
	
	@ManyToOne()
	protected Product product;
	
	/**
	 * 
	 */
	public ProductProperty() {
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}


	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}


	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductProperty other = (ProductProperty) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProductProperty [value=" + value + ", id=" + id + "]";
	}
	

}
