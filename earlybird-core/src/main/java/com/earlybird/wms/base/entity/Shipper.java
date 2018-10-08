/**
 * 
 */
package com.earlybird.wms.base.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.earlybird.wms.base.entity.constants.ShipperStatus;



/**
 * @author Peili Zhou
 *
 */
@Entity
public class Shipper extends BaseEntity {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5976566224440264503L;


	@ManyToOne()
	protected ShipperType shipperType;
	
	
	@Column
	@Enumerated(EnumType.STRING)
	protected ShipperStatus status = ShipperStatus.ACTIVE;
	
	@ManyToOne
	Shipper parent;
	
	@OneToMany(mappedBy="parent")
	List<Shipper> children = new ArrayList<>();
	
	@ManyToOne
	Location location;
	
	
	@OneToMany(mappedBy="shipper")
	protected List<Inventory> inventories = new ArrayList<>();
	
	

	
	/**
	 * 
	 */
	public Shipper() {
		// TODO Auto-generated constructor stub
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
	 * @return the shipperType
	 */
	public ShipperType getShipperType() {
		return shipperType;
	}

	/**
	 * @param shipperType the shipperType to set
	 */
	public void setShipperType(ShipperType shipperType) {
		this.shipperType = shipperType;
	}

	/**
	 * @return the status
	 */
	public ShipperStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(ShipperStatus status) {
		this.status = status;
	}

	/**
	 * @return the parent
	 */
	public Shipper getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(Shipper parent) {
		this.parent = parent;
	}

	/**
	 * @return the children
	 */
	public List<Shipper> getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(List<Shipper> children) {
		this.children = children;
	}

	/**
	 * Add child shipper
	 * @param shipper
	 */
	public void addShipper(Shipper shipper) {
		this.children.add(shipper);
	}

	/**
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Shipper [id=" + id + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((children == null) ? 0 : children.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		result = prime * result + ((shipperType == null) ? 0 : shipperType.hashCode());
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
		Shipper other = (Shipper) obj;
		if (children == null) {
			if (other.children != null)
				return false;
		} else if (!children.equals(other.children))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		if (shipperType == null) {
			if (other.shipperType != null)
				return false;
		} else if (!shipperType.equals(other.shipperType))
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	
	
}
