/**
 * 
 */
package com.earlybird.wms.base.entity.constants;

/**
 * @author Peili Zhou
 *
 */
public enum ProductStatus implements EnumConstant{

	ACTIVE("ACTIVE");

	private final String value;
	
	private ProductStatus(String value) {
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
