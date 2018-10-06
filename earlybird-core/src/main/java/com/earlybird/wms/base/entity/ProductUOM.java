/**
 * 
 */
package com.earlybird.wms.base.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * @author Peili Zhou
 *
 */
@Entity(name="PRODUCT_UOM")
public class ProductUOM extends BaseEntity {
	/**
	 * 
	 */
	protected static final long serialVersionUID = 4591425746443859219L;

	@Column(name="PICKING_UOM",nullable=false,columnDefinition="boolean NOT NULL DEFAULT FALSE")
	protected boolean pickingUOM = false;
	
	@Column(name="PUTAWAY_UOM",nullable=false,columnDefinition="boolean NOT NULL DEFAULT FALSE")
	protected boolean putawayUOM = false;
	
	@Column(name="RECEIVING_UOM",nullable=false,columnDefinition="boolean NOT NULL DEFAULT FALSE")
	protected boolean receivingUOM = false;
	
	@Embedded
	protected Dimension dimension;
	
	@Column(nullable=false,columnDefinition="boolean NOT NULL DEFAULT FALSE")
	protected boolean baseUOM = false;
	
	@Column(nullable=false,columnDefinition="boolean NOT NULL DEFAULT 1")
	protected double ratioToBaseUom = 1.0;
	
	
	@NotNull
    @ManyToOne()
    @JoinColumn(nullable = false)
    protected UOM uom;
	
	@NotNull
    @ManyToOne()
	@JoinColumn(nullable=false)
	protected Product product;
	
	/**
	 * 
	 */
	public ProductUOM() {
		
	}
	
	
	
	/**
	 * @return the ratioToBaseUom
	 */
	public double getRatioToBaseUom() {
		return ratioToBaseUom;
	}



	/**
	 * @param ratioToBaseUom the ratioToBaseUom to set
	 */
	public void setRatioToBaseUom(double ratioToBaseUom) {
		this.ratioToBaseUom = ratioToBaseUom;
	}



	/**
	 * @return the pickingUOM
	 */
	public boolean isPickingUOM() {
		return pickingUOM;
	}


	/**
	 * @param pickingUOM the pickingUOM to set
	 */
	public void setPickingUOM(boolean pickingUOM) {
		this.pickingUOM = pickingUOM;
	}


	/**
	 * @return the putawayUOM
	 */
	public boolean isPutawayUOM() {
		return putawayUOM;
	}


	/**
	 * @param putawayUOM the putawayUOM to set
	 */
	public void setPutawayUOM(boolean putawayUOM) {
		this.putawayUOM = putawayUOM;
	}


	/**
	 * @return the receivingUOM
	 */
	public boolean isReceivingUOM() {
		return receivingUOM;
	}


	/**
	 * @param receivingUOM the receivingUOM to set
	 */
	public void setReceivingUOM(boolean receivingUOM) {
		this.receivingUOM = receivingUOM;
	}


	

	/**
	 * @return the uom
	 */
	public UOM getUom() {
		return uom;
	}


	/**
	 * @param uom the uom to set
	 */
	public void setUom(UOM uom) {
		this.uom = uom;
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
	 * @return the baseUOM
	 */
	public boolean isBaseUOM() {
		return baseUOM;
	}


	/**
	 * @param baseUOM the baseUOM to set
	 */
	public void setBaseUOM(boolean baseUOM) {
		this.baseUOM = baseUOM;
	}

	

	/**
	 * @return the dimension
	 */
	public Dimension getDimension() {
		return dimension;
	}



	/**
	 * @param dimension the dimension to set
	 */
	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProductUOM [id=" + id + "]";
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (baseUOM ? 1231 : 1237);
		result = prime * result + (pickingUOM ? 1231 : 1237);
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + (putawayUOM ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(ratioToBaseUom);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (receivingUOM ? 1231 : 1237);
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
		ProductUOM other = (ProductUOM) obj;
		if (baseUOM != other.baseUOM)
			return false;
		if (pickingUOM != other.pickingUOM)
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (putawayUOM != other.putawayUOM)
			return false;
		if (Double.doubleToLongBits(ratioToBaseUom) != Double.doubleToLongBits(other.ratioToBaseUom))
			return false;
		if (receivingUOM != other.receivingUOM)
			return false;
		return true;
	}


	
	
	
	
}
