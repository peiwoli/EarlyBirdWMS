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

import com.earlybird.wms.base.entity.constants.AsnStatus;

/**
 * @author Peili Zhou
 *
 */
@Entity
public class Asn extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9003586951431622798L;

	@Column(nullable=false)
	protected String asnType = "DEFAULT";
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, mappedBy="asn")
	protected List<AsnLine> asnLines = new ArrayList<>();
	
	@Column
	@Enumerated(EnumType.STRING)
	protected AsnStatus status = AsnStatus.UNPROC;
	
	
	/**
	 * 
	 */
	public Asn() {
		
	}


	/**
	 * @return the asnType
	 */
	public String getAsnType() {
		return asnType;
	}


	/**
	 * @param asnType the asnType to set
	 */
	public void setAsnType(String asnType) {
		this.asnType = asnType;
	}


	/**
	 * @return the status
	 */
	public AsnStatus getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(AsnStatus status) {
		this.status = status;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Asn [status=" + status + ", id=" + id + "]";
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((asnType == null) ? 0 : asnType.hashCode());
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
		Asn other = (Asn) obj;
		if (asnType == null) {
			if (other.asnType != null)
				return false;
		} else if (!asnType.equals(other.asnType))
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	
	
	

}
