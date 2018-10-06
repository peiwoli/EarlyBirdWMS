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
public class Bay extends BaseEntity {

	@OneToMany(mappedBy="bay")
	protected List<Slot> slots = new ArrayList<>();
	
	@ManyToOne
	protected Aisle aisle;
	
	@OneToMany(mappedBy="bay")
	protected List<Location> locations = new ArrayList<>();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3063958674429215175L;

	/**
	 * 
	 */
	public Bay() {
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
	 * @return the aisle
	 */
	public Aisle getAisle() {
		return aisle;
	}


	/**
	 * @param aisle the aisle to set
	 */
	public void setAisle(Aisle aisle) {
		this.aisle = aisle;
	}


	/**
	 * @return the slots
	 */
	public List<Slot> getSlots() {
		return slots;
	}

	/**
	 * @param slots the slots to set
	 */
	public void setSlots(List<Slot> slots) {
		this.slots = slots;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Bay [id=" + id + "]";
	}
	
	
	

}
