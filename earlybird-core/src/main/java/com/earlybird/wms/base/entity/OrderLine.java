package com.earlybird.wms.base.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.earlybird.wms.base.entity.constants.OrderLineStatus;

/**
 * 
 * @author Peili Zhou
 *
 */
@Entity
public class OrderLine extends BaseEntity  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5684151500233839898L;

	
	@Column(nullable=false,columnDefinition="DOUBLE NOT NULL DEFAULT 0")
	protected double orderLineNumber = 0;
	
	@Column(nullable=false,columnDefinition="DOUBLE NOT NULL DEFAULT 0")
	protected double quantityRequired = 0;
	
	@Column(nullable=false,columnDefinition="DOUBLE NOT NULL DEFAULT 0")
	protected double quantityPicked = 0;
	
	@Column(nullable=false,columnDefinition="DOUBLE NOT NULL DEFAULT 0")
	protected double quantityAllocated = 0;
	
	@Column(nullable=false,columnDefinition="DOUBLE NOT NULL DEFAULT 0")
	protected double quantityCancelled = 0;

	
	@ManyToOne
	protected Order order;
	
	@Column
	@Enumerated(EnumType.STRING)
	protected OrderLineStatus status = OrderLineStatus.UNPROC;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, mappedBy="orderLine")
	protected List<PickTask> tasks = new ArrayList<>();
	
	
	/**
	 * Constructor
	 */
	public OrderLine() {
		
	}

	/**
	 * @return the tasks
	 */
	public List<PickTask> getTasks() {
		return tasks;
	}

	/**
	 * @param tasks the tasks to set
	 */
	public void setTasks(List<PickTask> tasks) {
		this.tasks = tasks;
	}

	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}


	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}


	/**
	 * @return the status
	 */
	public OrderLineStatus getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(OrderLineStatus status) {
		this.status = status;
	}


	/**
	 * @return the orderLineNumber
	 */
	public double getOrderLineNumber() {
		return orderLineNumber;
	}



	/**
	 * @param orderLineNumber the orderLineNumber to set
	 */
	public void setOrderLineNumber(double orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
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
	 * @return the quantityPicked
	 */
	public double getQuantityPicked() {
		return quantityPicked;
	}



	/**
	 * @param quantityPicked the quantityPicked to set
	 */
	public void setQuantityPicked(double quantityPicked) {
		this.quantityPicked = quantityPicked;
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



	@Override
	public String toString() {
		return "OrderLine [orderLineNumber=" + orderLineNumber + ", quantityRequired=" + quantityRequired
				+ ", quantityPicked=" + quantityPicked + ", quantityAllocated=" + quantityAllocated
				+ ", quantityCancelled=" + quantityCancelled + "]";
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(orderLineNumber);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(quantityAllocated);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(quantityCancelled);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(quantityPicked);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(quantityRequired);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderLine other = (OrderLine) obj;
		if (Double.doubleToLongBits(orderLineNumber) != Double.doubleToLongBits(other.orderLineNumber))
			return false;
		if (Double.doubleToLongBits(quantityAllocated) != Double.doubleToLongBits(other.quantityAllocated))
			return false;
		if (Double.doubleToLongBits(quantityCancelled) != Double.doubleToLongBits(other.quantityCancelled))
			return false;
		if (Double.doubleToLongBits(quantityPicked) != Double.doubleToLongBits(other.quantityPicked))
			return false;
		if (Double.doubleToLongBits(quantityRequired) != Double.doubleToLongBits(other.quantityRequired))
			return false;
		return true;
	}
	
	
	
	
}
