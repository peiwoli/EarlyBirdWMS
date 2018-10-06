/**
 * 
 */
package com.earlybird.wms.base.entity.constants;

/**
 * @author Peili Zhou
 *
 */
public enum OrderLineStatus implements EnumConstant {
	UNPROC("UNPROC"),
	PICKING("PICKING"),
	SHORTED("SHORTED"),
	CANCELLED("CANCELLED"),
	COMPLETED("COMPLETED");
	
	private String value;
	
	private OrderLineStatus(String value) {
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see com.earlybird.wms.base.entity.status.EnumConstant#getValue()
	 */
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return value;
	}

}
