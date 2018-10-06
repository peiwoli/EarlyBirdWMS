/**
 * 
 */
package com.earlybird.wms.base.entity.constants;

/**
 * @author Peili Zhou
 *
 */
public enum OrderStatus implements EnumConstant {
	
	UNPROC("UNPROC"),
	ACTIVE("ACTIVE"),
	SHORTED("SHORTED"),
	CANCELLED("CANCELLED"),
	COMPLETED("COMPLETED");
	
	private final String value;
	
	private OrderStatus(String value) {
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
