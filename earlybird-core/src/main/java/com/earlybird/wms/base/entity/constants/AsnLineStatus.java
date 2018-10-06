/**
 * 
 */
package com.earlybird.wms.base.entity.constants;

/**
 * @author Peili Zhou
 *
 */
public enum AsnLineStatus implements EnumConstant {
	UNPROC("UNPROC"),
	ACTIVE("ACTIVE"),
	SHORTED("SHORTED"),
	CANCELLED("CANCELLED"),
	COMPLETED("COMPLETED");
	
	private String value;
	
	private AsnLineStatus(String value) {
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see com.earlybird.wms.base.entity.constants.EnumConstant#getValue()
	 */
	@Override
	public String getValue() {
		
		return value;
	}

}
