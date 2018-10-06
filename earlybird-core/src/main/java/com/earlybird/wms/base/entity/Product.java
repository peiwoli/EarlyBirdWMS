/**
 * 
 */
package com.earlybird.wms.base.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import com.earlybird.wms.base.entity.constants.ProductStatus;

/**
 * @author Peili Zhou
 *
 */
@Entity
public class Product extends BaseEntity {

	@Column
	protected String description ;
	
	@Column(name="IMAGE_PATH", nullable=true)
	protected String imagePath;
	
	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	protected ProductStatus status = ProductStatus.ACTIVE;

	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, mappedBy="product")
	protected List<ProductUOM> productUoms = new ArrayList<>();
	
	@OneToMany(mappedBy="key")
	protected List<ProductProperty> productProperties = new ArrayList<>();
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5529060868080402825L;

	/**
	 * 
	 */
	public Product() {
		
	}

	



	/**
	 * @return the productUoms
	 */
	public List<ProductUOM> getProductUoms() {
		return productUoms;
	}





	/**
	 * @param productUoms the productUoms to set
	 */
	public void setProductUoms(List<ProductUOM> productUoms) {
		this.productUoms = productUoms;
	}


	/**
	 * 
	 * @param productUOM the productUOM to add
	 */
	public void addProductUOM(ProductUOM productUOM) {
		this.productUoms.add(productUOM);
	}



	/**
	 * @return the productProperties
	 */
	public List<ProductProperty> getProductProperties() {
		return productProperties;
	}




	/**
	 * @param productProperties the productProperties to set
	 */
	public void setProductProperties(List<ProductProperty> productProperties) {
		this.productProperties = productProperties;
	}


	public void addProductProperty(ProductProperty productProperty) {
		this.productProperties.add(productProperty);
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	

	/**
	 * @return the imagePath
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * @param imagePath the imagePath to set
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	/**
	 * @return the status
	 */
	public ProductStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(ProductStatus status) {
		this.status = status;
	}
	
	

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [id=" + id + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((imagePath == null) ? 0 : imagePath.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Product other = (Product) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (imagePath == null) {
			if (other.imagePath != null)
				return false;
		} else if (!imagePath.equals(other.imagePath))
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	
	
	

}
