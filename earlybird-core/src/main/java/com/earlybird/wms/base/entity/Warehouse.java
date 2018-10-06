/**
 * 
 */
package com.earlybird.wms.base.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * @author Peili Zhou
 *
 */
@Entity
public class Warehouse extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1507008901117445054L;

	@OneToMany(mappedBy="area")
	protected List<Area> areas = new ArrayList<>();
	
	/**
	 * 
	 */
	public Warehouse() {
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * @return the areas
	 */
	public List<Area> getAreas() {
		return areas;
	}



	/**
	 * @param areas the areas to set
	 */
	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((areas == null) ? 0 : areas.hashCode());
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
		Warehouse other = (Warehouse) obj;
		if (areas == null) {
			if (other.areas != null)
				return false;
		} else if (!areas.equals(other.areas))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Warehouse [id=" + id + "]";
	}

	
	
}
