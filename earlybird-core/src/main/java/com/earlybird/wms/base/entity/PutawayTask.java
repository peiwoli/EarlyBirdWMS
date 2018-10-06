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
@DiscriminatorValue("PutawayTask")
public class PutawayTask extends Task {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 31565556317093177L;
	
	@ManyToOne
	protected AsnLine asnLine;
	
	/**
	 * 
	 */
	public PutawayTask() {
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PutawayTask [id=" + id + "]";
	}

	/**
	 * @return the asnLine
	 */
	public AsnLine getAsnLine() {
		return asnLine;
	}

	/**
	 * @param asnLine the asnLine to set
	 */
	public void setAsnLine(AsnLine asnLine) {
		this.asnLine = asnLine;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((asnLine == null) ? 0 : asnLine.hashCode());
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
		PutawayTask other = (PutawayTask) obj;
		if (asnLine == null) {
			if (other.asnLine != null)
				return false;
		} else if (!asnLine.equals(other.asnLine))
			return false;
		return true;
	}

	
}
