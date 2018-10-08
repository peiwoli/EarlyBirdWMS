/**
 * 
 */
package com.earlybird.wms.base.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import com.earlybird.wms.base.entity.constants.ConsolidationRule;

/**
 * @author Peili Zhou
 *
 */
@Entity
public class LocationProfile extends BaseEntity {

	
	@OneToMany(orphanRemoval=true, mappedBy="locationProfile")
	protected List<Location> locations = new ArrayList<Location>();
	
	@Column
	protected String description;
	
	/**
	 * Use {@link Dimension}
	 */
	@Column(nullable=false,columnDefinition="boolean NOT NULL DEFAULT FALSE")
	protected boolean calculateDimensionCapacity = false;
	
	/**
	 * Use {@link Dimension}
	 */
	@Column(nullable=false,columnDefinition="boolean NOT NULL DEFAULT FALSE")
	protected boolean calculateWeightCapacity = false;
	
	/**
	 * To use {@code #maxCapacity} and {@code #minCapacity}
	 */
	@Column(nullable=false,columnDefinition="boolean NOT NULL DEFAULT FALSE")
	protected boolean calculateCapacity = false;
	
	@Column(nullable=false,columnDefinition="DOUBLE NOT NULL DEFAULT 0")
	protected double maxCapacity = 0.0;
	
	@Column(nullable=false,columnDefinition="DOUBLE NOT NULL DEFAULT 0")
	protected double minCapacity = 0.0;
	
    @Embedded
    @Valid
    private Dimension dimension = new Dimension();
	
    
	@Column
	@Enumerated(EnumType.STRING)
	protected ConsolidationRule consolidationRule = ConsolidationRule.SAME_PRODUCT_SAME_PROPERTY;
	
	/**
	 * {@link AsnLine} can be allowed to be received into this location
	 */
	@Column(nullable=false,columnDefinition="BOOLEAN NOT NULL DEFAULT FALSE")
	boolean receivingLocation = false;
	
	/**
	 * A consolidate location before order gets despatched.
	 */
	@Column(nullable=false,columnDefinition="BOOLEAN NOT NULL DEFAULT FALSE")
	boolean despatchConsolidationLocation = false;
	
	/**
	 * A utility staging location for inventory/shippers to be staged somewhere.
	 */
	@Column(nullable=false,columnDefinition="BOOLEAN NOT NULL DEFAULT FALSE")
	boolean stagingLocation = false;

	/**
	 * Virtual location. No physical space
	 */
	@Column(nullable=false,columnDefinition="BOOLEAN NOT NULL DEFAULT FALSE")
	boolean virtualLocation = false;
	
	/**
	 * To put damaged/dirty/not available products into this location. Inventories in it shall not be allowed for picking/receiving/putaway/cycle count
	 */
	@Column(nullable=false,columnDefinition="BOOLEAN NOT NULL DEFAULT FALSE")
	boolean quarantineLocation = false;
	
	/**
	 * To indicate {@link Inventory} can be putaway into this location
	 */
	@Column(nullable=false,columnDefinition="BOOLEAN NOT NULL DEFAULT TRUE")
	boolean putawayLocation = true;
	
	/**
	 * To indicate {@link Inventory} can be picked and allocated from this location to fulfill orders
	 */
	@Column(nullable=false,columnDefinition="BOOLEAN NOT NULL DEFAULT TRUE")
	boolean pickingLocation = true;
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1934409883263777579L;

	/**
	 * 
	 */
	public LocationProfile() {
	
	}

	
	
	/**
	 * @return the quarantineLocation
	 */
	public boolean isQuarantineLocation() {
		return quarantineLocation;
	}



	/**
	 * @param quarantineLocation the quarantineLocation to set
	 */
	public void setQuarantineLocation(boolean quarantineLocation) {
		this.quarantineLocation = quarantineLocation;
	}



	/**
	 * @return the putawayLocation
	 */
	public boolean isPutawayLocation() {
		return putawayLocation;
	}



	/**
	 * @param putawayLocation the putawayLocation to set
	 */
	public void setPutawayLocation(boolean putawayLocation) {
		this.putawayLocation = putawayLocation;
	}



	/**
	 * @return the pickingLocation
	 */
	public boolean isPickingLocation() {
		return pickingLocation;
	}



	/**
	 * @param pickingLocation the pickingLocation to set
	 */
	public void setPickingLocation(boolean pickingLocation) {
		this.pickingLocation = pickingLocation;
	}



	/**
	 * @return the receivingLocation
	 */
	public boolean isReceivingLocation() {
		return receivingLocation;
	}


	/**
	 * @param receivingLocation the receivingLocation to set
	 */
	public void setReceivingLocation(boolean receivingLocation) {
		this.receivingLocation = receivingLocation;
	}


	/**
	 * @return the despatchConsolidationLocation
	 */
	public boolean isDespatchConsolidationLocation() {
		return despatchConsolidationLocation;
	}


	/**
	 * @param despatchConsolidationLocation the despatchConsolidationLocation to set
	 */
	public void setDespatchConsolidationLocation(boolean despatchConsolidationLocation) {
		this.despatchConsolidationLocation = despatchConsolidationLocation;
	}


	/**
	 * @return the stagingLocation
	 */
	public boolean isStagingLocation() {
		return stagingLocation;
	}


	/**
	 * @param stagingLocation the stagingLocation to set
	 */
	public void setStagingLocation(boolean stagingLocation) {
		this.stagingLocation = stagingLocation;
	}


	/**
	 * @return the virtualLocation
	 */
	public boolean isVirtualLocation() {
		return virtualLocation;
	}


	/**
	 * @param virtualLocation the virtualLocation to set
	 */
	public void setVirtualLocation(boolean virtualLocation) {
		this.virtualLocation = virtualLocation;
	}


	/**
	 * @return the consolidationRule
	 */
	public ConsolidationRule getConsolidationRule() {
		return consolidationRule;
	}


	/**
	 * @param consolidationRule the consolidationRule to set
	 */
	public void setConsolidationRule(ConsolidationRule consolidationRule) {
		this.consolidationRule = consolidationRule;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the calculateDimensionCapacity
	 */
	public boolean isCalculateDimensionCapacity() {
		return calculateDimensionCapacity;
	}

	/**
	 * @param calculateDimensionCapacity the calculateDimensionCapacity to set
	 */
	public void setCalculateDimensionCapacity(boolean calculateDimensionCapacity) {
		this.calculateDimensionCapacity = calculateDimensionCapacity;
	}

	/**
	 * @return the calculateWeightCapacity
	 */
	public boolean isCalculateWeightCapacity() {
		return calculateWeightCapacity;
	}

	/**
	 * @param calculateWeightCapacity the calculateWeightCapacity to set
	 */
	public void setCalculateWeightCapacity(boolean calculateWeightCapacity) {
		this.calculateWeightCapacity = calculateWeightCapacity;
	}

	/**
	 * @return the calculateCapacity
	 */
	public boolean isCalculateCapacity() {
		return calculateCapacity;
	}

	/**
	 * @param calculateCapacity the calculateCapacity to set
	 */
	public void setCalculateCapacity(boolean calculateCapacity) {
		this.calculateCapacity = calculateCapacity;
	}

	/**
	 * @return the maxCapacity
	 */
	public double getMaxCapacity() {
		return maxCapacity;
	}

	/**
	 * @param maxCapacity the maxCapacity to set
	 */
	public void setMaxCapacity(double maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	/**
	 * @return the minCapacity
	 */
	public double getMinCapacity() {
		return minCapacity;
	}

	/**
	 * @param minCapacity the minCapacity to set
	 */
	public void setMinCapacity(double minCapacity) {
		this.minCapacity = minCapacity;
	}

	/**
	 * @return the dimension
	 */
	public Dimension getDimension() {
		return dimension;
	}

	/**
	 * @param dimension the dimension to set
	 */
	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (calculateCapacity ? 1231 : 1237);
		result = prime * result + (calculateDimensionCapacity ? 1231 : 1237);
		result = prime * result + (calculateWeightCapacity ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(maxCapacity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(minCapacity);
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
		LocationProfile other = (LocationProfile) obj;
		if (calculateCapacity != other.calculateCapacity)
			return false;
		if (calculateDimensionCapacity != other.calculateDimensionCapacity)
			return false;
		if (calculateWeightCapacity != other.calculateWeightCapacity)
			return false;
		if (Double.doubleToLongBits(maxCapacity) != Double.doubleToLongBits(other.maxCapacity))
			return false;
		if (Double.doubleToLongBits(minCapacity) != Double.doubleToLongBits(other.minCapacity))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LocationProfile [id=" + id + "]";
	}

	
	
	
}
