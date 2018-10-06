/**
 * 
 */
package com.earlybird.wms.base.entity.constants;

/**
 * @author Peili Zhou
 *
 */
public enum RoleStatus implements EnumConstant{

	ENABLED("ENABLED"),DISABLED("DISABLED");
	
	private final String value;
	
	private RoleStatus(String value) {
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see com.earlybird.wms.base.entity.status.EnumConstant#getValue()
	 */
	@Override
	public String getValue() {
		return this.value;
	}
}
