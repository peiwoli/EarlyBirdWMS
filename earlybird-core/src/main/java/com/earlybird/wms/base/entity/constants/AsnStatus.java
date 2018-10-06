/**
 * 
 */
package com.earlybird.wms.base.entity.constants;

/**
 * @author Peili Zhou
 *
 */
public enum AsnStatus implements EnumConstant {
	UNPROC("UNPROC"),
	ACTIVE("ACTIVE"),
	SHORTED("SHORTED"),
	CANCELLED("CANCELLED"),
	COMPLETED("COMPLETED");
	
	private String value;
	
	private AsnStatus(String value) {
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
