/**
 * 
 */
package com.earlybird.wms.base.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Peili Zhou
 *
 */
@Entity
public class Area extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4622334996594326753L;
	
	@OneToMany(mappedBy="area")
	List<Zone> zones = new ArrayList<>();
	
	@ManyToOne
	Area area;
	
	/**
	 * 
	 */
	public Area() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	/**
	 * @return the area
	 */
	public Area getArea() {
		return area;
	}



	/**
	 * @param area the area to set
	 */
	public void setArea(Area area) {
		this.area = area;
	}



	/**
	 * @return the zones
	 */
	public List<Zone> getZones() {
		return zones;
	}
	/**
	 * @param zones the zones to set
	 */
	public void setZones(List<Zone> zones) {
		this.zones = zones;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((zones == null) ? 0 : zones.hashCode());
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
		Area other = (Area) obj;
		if (zones == null) {
			if (other.zones != null)
				return false;
		} else if (!zones.equals(other.zones))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Area [id=" + id + "]";
	}

	
	
}
