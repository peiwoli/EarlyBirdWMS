/**
 * 
 */
package com.earlybird.wms.base.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

/**
 * @author Peili Zhou
 *
 */
@Entity
public class ShipperType extends BaseEntity {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4344460430955708833L;

	@Embedded
	Dimension dimesion;
	
	@Column(nullable=false,columnDefinition="boolean NOT NULL DEFAULT FALSE")
	protected boolean baseShipper = false;
	
	@Column(nullable=false,columnDefinition="boolean NOT NULL DEFAULT 1")
	protected double ratioToBaseShipperType = 1.0;
	
	/**
	 * 
	 */
	public ShipperType() {
		
	}
	
	

	


	/**
	 * @return the dimesion
	 */
	public Dimension getDimesion() {
		return dimesion;
	}






	/**
	 * @param dimesion the dimesion to set
	 */
	public void setDimesion(Dimension dimesion) {
		this.dimesion = dimesion;
	}






	/**
	 * @return the baseShipper
	 */
	public boolean isBaseShipper() {
		return baseShipper;
	}



	/**
	 * @param baseShipper the baseShipper to set
	 */
	public void setBaseShipper(boolean baseShipper) {
		this.baseShipper = baseShipper;
	}



	/**
	 * @return the ratioToBaseShipperType
	 */
	public double getRatioToBaseShipperType() {
		return ratioToBaseShipperType;
	}



	/**
	 * @param ratioToBaseShipperType the ratioToBaseShipperType to set
	 */
	public void setRatioToBaseShipperType(double ratioToBaseShipperType) {
		this.ratioToBaseShipperType = ratioToBaseShipperType;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ShipperType [id=" + id + "]";
	}






	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (baseShipper ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(ratioToBaseShipperType);
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
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShipperType other = (ShipperType) obj;
		if (baseShipper != other.baseShipper)
			return false;
		if (Double.doubleToLongBits(ratioToBaseShipperType) != Double.doubleToLongBits(other.ratioToBaseShipperType))
			return false;
		return true;
	}




	
	

}
