/**
 * 
 */
package com.earlybird.wms.base.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Peili Zhou
 *
 */
@Entity
public class Location extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3908028366734221836L;

	@Embedded
	protected Position position;
	
	@ManyToOne
	protected Location parent;
	
	
	@OneToMany(mappedBy="parent")
	protected List<Location> children = new ArrayList<>();
	
	@Column
	protected String barcode;
	
	@Column
	protected String checkDigit;
	
	
	@Column(nullable=false,columnDefinition="INT NOT NULL DEFAULT 0")
	protected int travelPath = 0;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, mappedBy="location")
	protected List<Inventory> inventories = new ArrayList<>();
	
	
	@OneToMany(mappedBy="key")
	protected List<Shipper> shippers = new ArrayList<>();
	
	@ManyToOne
	protected Slot slot;
	
	@ManyToOne
	protected Bay bay;
	
	@ManyToOne
	protected Aisle aisle;
	
	@ManyToOne
	protected Zone zone;
	
	@ManyToOne
	protected LocationProfile locationProfile;
	
	/**
	 * 
	 */
	public Location() {
		
	}

	
	


	/**
	 * @return the locationProfile
	 */
	public LocationProfile getLocationProfile() {
		return locationProfile;
	}





	/**
	 * @param locationProfile the locationProfile to set
	 */
	public void setLocationProfile(LocationProfile locationProfile) {
		this.locationProfile = locationProfile;
	}





	/**
	 * @return the zone
	 */
	public Zone getZone() {
		return zone;
	}


	/**
	 * @param zone the zone to set
	 */
	public void setZone(Zone zone) {
		this.zone = zone;
	}


	/**
	 * @return the slot
	 */
	public Slot getSlot() {
		return slot;
	}


	/**
	 * @param slot the slot to set
	 */
	public void setSlot(Slot slot) {
		this.slot = slot;
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
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

	/**
	 * @return the parent
	 */
	public Location getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(Location parent) {
		this.parent = parent;
	}

	/**
	 * @return the children
	 */
	public List<Location> getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(List<Location> children) {
		this.children = children;
	}
	
	/**
	 * 
	 * @param location location to set
	 */
	public void addLocation(Location location) {
		this.children.add(location);
	}

	
	/**
	 * @return the barcode
	 */
	public String getBarcode() {
		return barcode;
	}

	/**
	 * @param barcode the barcode to set
	 */
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	/**
	 * @return the checkDigit
	 */
	public String getCheckDigit() {
		return checkDigit;
	}

	/**
	 * @param checkDigit the checkDigit to set
	 */
	public void setCheckDigit(String checkDigit) {
		this.checkDigit = checkDigit;
	}

	/**
	 * @return the travelPath
	 */
	public int getTravelPath() {
		return travelPath;
	}

	/**
	 * @param travelPath the travelPath to set
	 */
	public void setTravelPath(int travelPath) {
		this.travelPath = travelPath;
	}
	
	



	/**
	 * @return the inventories
	 */
	public List<Inventory> getInventories() {
		return inventories;
	}

	/**
	 * @param inventories the inventories to set
	 */
	public void setInventories(List<Inventory> inventories) {
		this.inventories = inventories;
	}
	
	/**
	 * 
	 * @param inventory inventory to add
	 */
	public void addInventory(Inventory inventory) {
		this.inventories.add(inventory);
	}

	
	
	/**
	 * @return the shippers
	 */
	public List<Shipper> getShippers() {
		return shippers;
	}

	/**
	 * @param shippers the shippers to set
	 */
	public void setShippers(List<Shipper> shippers) {
		this.shippers = shippers;
	}
	
	/**
	 * 
	 * @param shipper shipper to add
	 */
	public void addShipper(Shipper shipper) {
		this.shippers.add(shipper);
	}
	
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Location [id=" + id + "]";
	}

	
}
