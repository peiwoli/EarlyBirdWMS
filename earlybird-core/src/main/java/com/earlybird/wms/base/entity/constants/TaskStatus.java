/**
 * 
 */
package com.earlybird.wms.base.entity.constants;

/**
 * @author Peili Zhou
 *
 */
public enum TaskStatus implements EnumConstant {
	UNPROC("UNPROC"),
	ACTIVE("ACTIVE"),
	SUSPENDED("SUSPENDED"),
	COMPLETED("COMPLETED");
	
	private String value;
	
	private TaskStatus(String value) {
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
