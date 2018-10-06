/**
 * 
 */
package com.earlybird.wms.base.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import com.earlybird.wms.base.entity.constants.AsnLineStatus;

/**
 * @author Peili Zhou
 *
 */
@Entity
public class AsnLine extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -931010727843248715L;

	@Column(nullable=false,columnDefinition="INT NOT NULL DEFAULT 0")
	protected int asnLineNumber = 0;
	
	@ManyToOne
	protected Asn asn;
	
	@NotNull
	@ManyToOne
	protected ShipperType shipperType;
	
	@NotNull
	@ManyToOne
	protected Product product;
	
	@NotNull
	@ManyToOne
	protected ProductUOM productUom;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	protected Date receivedDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	protected Date bestBeforeDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	protected Date expireDate;
	
	@Column(nullable=false,columnDefinition="DOUBLE NOT NULL DEFAULT 0")
	protected double quantityRequired = 0;
	
	@Column(nullable=false,columnDefinition="DOUBLE NOT NULL DEFAULT 0")
	protected double quantityReceived = 0;
	
	@Column(nullable=false,columnDefinition="DOUBLE NOT NULL DEFAULT 0")
	protected double quantityCancelled = 0;
	
	@Column(nullable=false,columnDefinition="DOUBLE NOT NULL DEFAULT 0")
	protected double quantityAllocatedForReceiving = 0;
	
	
	@Column
	@Enumerated(EnumType.STRING)
	protected AsnLineStatus status = AsnLineStatus.UNPROC;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, mappedBy="asnLine")
	protected List<ReceivingTask> receivingTasks = new ArrayList<>();
	
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, mappedBy="asnLine")
	protected List<PutawayTask> putawayTasks = new ArrayList<>();
	
	/**
	 * 
	 */
	public AsnLine() {
		
	}
	

	
	/**
	 * @return the quantityAllocatedForReceiving
	 */
	public double getQuantityAllocatedForReceiving() {
		return quantityAllocatedForReceiving;
	}



	/**
	 * @param quantityAllocatedForReceiving the quantityAllocatedForReceiving to set
	 */
	public void setQuantityAllocatedForReceiving(double quantityAllocatedForReceiving) {
		this.quantityAllocatedForReceiving = quantityAllocatedForReceiving;
	}



	/**
	 * @return the receivingTasks
	 */
	public List<ReceivingTask> getReceivingTasks() {
		return receivingTasks;
	}


	/**
	 * @param receivingTasks the receivingTasks to set
	 */
	public void setReceivingTasks(List<ReceivingTask> receivingTasks) {
		this.receivingTasks = receivingTasks;
	}


	/**
	 * @return the putawayTasks
	 */
	public List<PutawayTask> getPutawayTasks() {
		return putawayTasks;
	}


	/**
	 * @param putawayTasks the putawayTasks to set
	 */
	public void setPutawayTasks(List<PutawayTask> putawayTasks) {
		this.putawayTasks = putawayTasks;
	}


	/**
	 * @return the asnLineNumber
	 */
	public int getAsnLineNumber() {
		return asnLineNumber;
	}

	/**
	 * @param asnLineNumber the asnLineNumber to set
	 */
	public void setAsnLineNumber(int asnLineNumber) {
		this.asnLineNumber = asnLineNumber;
	}

	/**
	 * @return the asn
	 */
	public Asn getAsn() {
		return asn;
	}

	/**
	 * @param asn the asn to set
	 */
	public void setAsn(Asn asn) {
		this.asn = asn;
	}

	/**
	 * @return the shipperType
	 */
	public ShipperType getShipperType() {
		return shipperType;
	}

	/**
	 * @param shipperType the shipperType to set
	 */
	public void setShipperType(ShipperType shipperType) {
		this.shipperType = shipperType;
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
	 * @return the receivedDate
	 */
	public Date getReceivedDate() {
		return receivedDate;
	}

	/**
	 * @param receivedDate the receivedDate to set
	 */
	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
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
	 * @return the expireDate
	 */
	public Date getExpireDate() {
		return expireDate;
	}

	/**
	 * @param expireDate the expireDate to set
	 */
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	/**
	 * @return the quantityRequired
	 */
	public double getQuantityRequired() {
		return quantityRequired;
	}

	/**
	 * @param quantityRequired the quantityRequired to set
	 */
	public void setQuantityRequired(double quantityRequired) {
		this.quantityRequired = quantityRequired;
	}

	/**
	 * @return the quantityReceived
	 */
	public double getQuantityReceived() {
		return quantityReceived;
	}

	/**
	 * @param quantityReceived the quantityReceived to set
	 */
	public void setQuantityReceived(double quantityReceived) {
		this.quantityReceived = quantityReceived;
	}

	/**
	 * @return the quantityCancelled
	 */
	public double getQuantityCancelled() {
		return quantityCancelled;
	}

	/**
	 * @param quantityCancelled the quantityCancelled to set
	 */
	public void setQuantityCancelled(double quantityCancelled) {
		this.quantityCancelled = quantityCancelled;
	}

	/**
	 * @return the status
	 */
	public AsnLineStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(AsnLineStatus status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + asnLineNumber;
		long temp;
		temp = Double.doubleToLongBits(quantityCancelled);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(quantityReceived);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(quantityRequired);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((receivedDate == null) ? 0 : receivedDate.hashCode());
		result = prime * result + ((shipperType == null) ? 0 : shipperType.hashCode());
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
		AsnLine other = (AsnLine) obj;
		if (asnLineNumber != other.asnLineNumber)
			return false;
		if (Double.doubleToLongBits(quantityCancelled) != Double.doubleToLongBits(other.quantityCancelled))
			return false;
		if (Double.doubleToLongBits(quantityReceived) != Double.doubleToLongBits(other.quantityReceived))
			return false;
		if (Double.doubleToLongBits(quantityRequired) != Double.doubleToLongBits(other.quantityRequired))
			return false;
		if (receivedDate == null) {
			if (other.receivedDate != null)
				return false;
		} else if (!receivedDate.equals(other.receivedDate))
			return false;
		if (shipperType == null) {
			if (other.shipperType != null)
				return false;
		} else if (!shipperType.equals(other.shipperType))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AsnLine [asnLineNumber=" + asnLineNumber + ", id=" + id + "]";
	}
	
	
	

}
