/**
 * 
 */
package com.earlybird.wms.base.entity.constants;

/**
 * @author Peili Zhou
 *
 */
public enum OrderState implements EnumConstant {
	
	UNPROC("UNPROC"),
	ALLOCATION_ACTIVATED("ALLOCATION_ACTIVATED"),
	ALLOCATING("ALLOCATING"),
	ALLOCATED("ALLOCATED"),
	PARTIALLY_ALLOCATED("PARTIALLY_ALLOCATED"),
	RELEASED_ACTIVATED("RELEASE_ACTIVATED"),
	RELEASING("RELEASING"),
	RELEASED("RELEASED"),
	PICKING("PICKING"),
	SHORTED("SHORTED"),
	CANCELLED("CANCELLED"),
	PICKED("PICKED"),
	DESPATCHING("DESPATCHING"),
	DESPATCHED("DESPATCHED")
	;
	
	private String value;
	
	private OrderState(String value) {
		this.value = value;
	}
	/* (non-Javadoc)
	 * @see com.earlybird.wms.base.entity.status.EnumConstant#getValue()
	 */
	@Override
	public String getValue() {
		
		return value;
	}

}
