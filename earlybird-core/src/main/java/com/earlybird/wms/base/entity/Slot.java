/**
 * 
 */
package com.earlybird.wms.base.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Peili Zhou
 *
 */
@Entity
public class Slot extends BaseEntity {

	@ManyToOne
	protected Bay bay;
	
	@OneToMany(mappedBy="slot")
	List<Location> locations = new ArrayList<>();
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3617276313053686379L;

	/**
	 * 
	 */
	public Slot() {
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
	 * @return the bay
	 */
	public Bay getBay() {
		return bay;
	}



	/**
	 * @param bay the bay to set
	 */
	public void setBay(Bay bay) {
		this.bay = bay;
	}

	





	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((bay == null) ? 0 : bay.hashCode());
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
		Slot other = (Slot) obj;
		if (bay == null) {
			if (other.bay != null)
				return false;
		} else if (!bay.equals(other.bay))
			return false;
		return true;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Slot [id=" + id + "]";
	}

	
}
