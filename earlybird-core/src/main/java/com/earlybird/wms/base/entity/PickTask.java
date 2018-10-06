/**
 * 
 */
package com.earlybird.wms.base.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author Peili Zhou
 *
 */
@Entity
@DiscriminatorValue("PickTask")
public class PickTask extends Task {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3090954944262127126L;

	@ManyToOne
	protected OrderLine orderLine;
	
	/**
	 * 
	 */
	public PickTask() {
		
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PickTask [orderLine=" + orderLine + ", taskType=" + taskType + ", id=" + id + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((orderLine == null) ? 0 : orderLine.hashCode());
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
		PickTask other = (PickTask) obj;
		if (orderLine == null) {
			if (other.orderLine != null)
				return false;
		} else if (!orderLine.equals(other.orderLine))
			return false;
		return true;
	}
	
	
	
	

}
