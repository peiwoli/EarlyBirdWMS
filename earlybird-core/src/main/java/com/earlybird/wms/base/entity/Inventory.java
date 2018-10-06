/**
 * 
 */
package com.earlybird.wms.base.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Peili Zhou
 *
 */
@Entity
public class Inventory extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9185281590450638204L;

	@Column(nullable=false,columnDefinition="double NOT NULL DEFAULT 0")
	protected double quantity = 0.0;
	
	@Column(nullable=false,columnDefinition="double NOT NULL DEFAULT 0")
	protected double quantityAllocated = 0.0;
	
	@ManyToOne
	protected Product product;
	
	@ManyToOne
	protected ProductUOM productUom;
	
	@ManyToOne
	protected Location location;
	
	@ManyToOne
	protected Shipper shipper;
	
	/**
	 * The asnId of this inventory
	 */
	@Column
	protected String asnId;
	
	/**
	 * The asnLineId of this inventory
	 */
	@Column
	protected String asnLineId;
	
	@ManyToOne
	protected OrderLine orderLine;
	

	
	/**
	 * The inventory is assumed to be wrong. Awaiting cycle count check.
	 */
	@Column(nullable=false,columnDefinition="boolean NOT NULL DEFAULT FALSE") 
	boolean suspect = false;
	
	/**
	 * For dirty/damaged/not available inventories. No picking/allocation/cycle count is allowed
	 */
	@Column(nullable=false,columnDefinition="boolean NOT NULL DEFAULT FALSE")
	boolean damaged = false;
    
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column
    protected Date manufacturingDate;

    
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column
    private Date bestBeforeDate;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column
    protected Date expiryDate;
	
	/**
	 * 
	 */
	public Inventory() {
		
	}

	
	/**
	 * @return the productUom
	 */
	public ProductUOM getProductUom() {
		return productUom;
	}


	/**
	 * @param productUom the productUom to set
	 */
	public void setProductUom(ProductUOM productUom) {
		this.productUom = productUom;
	}


	/**
	 * @return the asnId
	 */
	public String getAsnId() {
		return asnId;
	}


	/**
	 * @param asnId the asnId to set
	 */
	public void setAsnId(String asnId) {
		this.asnId = asnId;
	}


	/**
	 * @return the asnLineId
	 */
	public String getAsnLineId() {
		return asnLineId;
	}


	/**
	 * @param asnLineId the asnLineId to set
	 */
	public void setAsnLineId(String asnLineId) {
		this.asnLineId = asnLineId;
	}


	/**
	 * @return the orderLine
	 */
	public OrderLine getOrderLine() {
		return orderLine;
	}


	/**
	 * @param orderLine the orderLine to set
	 */
	public void setOrderLine(OrderLine orderLine) {
		this.orderLine = orderLine;
	}


	/**
	 * @return the damaged
	 */
	public boolean isDamaged() {
		return damaged;
	}


	/**
	 * @param damaged the damaged to set
	 */
	public void setDamaged(boolean damaged) {
		this.damaged = damaged;
	}


	/**
	 * @return the quantity
	 */
	public double getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the quantityAllocated
	 */
	public double getQuantityAllocated() {
		return quantityAllocated;
	}

	/**
	 * @param quantityAllocated the quantityAllocated to set
	 */
	public void setQuantityAllocated(double quantityAllocated) {
		this.quantityAllocated = quantityAllocated;
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
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * @return the shipper
	 */
	public Shipper getShipper() {
		return shipper;
	}

	/**
	 * @param shipper the shipper to set
	 */
	public void setShipper(Shipper shipper) {
		this.shipper = shipper;
	}

	/**
	 * @return the suspect
	 */
	public boolean isSuspect() {
		return suspect;
	}

	/**
	 * @param suspect the suspect to set
	 */
	public void setSuspect(boolean suspect) {
		this.suspect = suspect;
	}

	/**
	 * @return the manufacturingDate
	 */
	public Date getManufacturingDate() {
		return manufacturingDate;
	}

	/**
	 * @param manufacturingDate the manufacturingDate to set
	 */
	public void setManufacturingDate(Date manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	/**
	 * @return the bestBeforeDate
	 */
	public Date getBestBeforeDate() {
		return bestBeforeDate;
	}

	/**
	 * @param bestBeforeDate the bestBeforeDate to set
	 */
	public void setBestBeforeDate(Date bestBeforeDate) {
		this.bestBeforeDate = bestBeforeDate;
	}

	/**
	 * @return the expiryDate
	 */
	public Date getExpiryDate() {
		return expiryDate;
	}

	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Inventory [quantity=" + quantity + ", product=" + product + ", location=" + location + ", shipper="
				+ shipper + "]";
	}
	
	

}
