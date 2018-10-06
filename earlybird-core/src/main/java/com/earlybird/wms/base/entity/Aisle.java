/**
 * 
 */
package com.earlybird.wms.base.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * @author Peili Zhou
 *
 */
@Entity
public class Aisle extends BaseEntity {

	@OneToMany(mappedBy="aisle")
	protected List<Bay> bays = new ArrayList<>();
	
	@OneToMany(mappedBy="aisle")
	protected List<Location> locations = new ArrayList<>();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -918068538305197595L;

	/**
	 * 
	 */
	public Aisle() {
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * @return the locations
	 */
	public List<Location> getLocations() {
		return locations;
	}



	/**
	 * @param locations the locations to set
	 */
	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}



	/**
	 * @return the bays
	 */
	public List<Bay> getBays() {
		return bays;
	}



	/**
	 * @param bays the bays to set
	 */
	public void setBays(List<Bay> bays) {
		this.bays = bays;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((bays == null) ? 0 : bays.hashCode());
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
		Aisle other = (Aisle) obj;
		if (bays == null) {
			if (other.bays != null)
				return false;
		} else if (!bays.equals(other.bays))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Aisle [id=" + id + "]";
	}
	
	

}
