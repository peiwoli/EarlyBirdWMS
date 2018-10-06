/**
 * 
 */
package com.earlybird.wms.base.entity.constants;

/**
 * @author Peili Zhou
 *
 */
public enum ConsolidationRule implements EnumConstant {
	SAME_PRODUCT_SAME_PROPERTY("SAME_PRODUCT_SAME_PROPERTY"),
	SAME_PRODUCT_MIX_PROPERTY("SAME_PRODUCT_MIX_PROPERTY"),
	MIX_PRODUCT_MIX_PROPERTY("MIX_PRODUCT_MIX_PROPERTY");

	private String value;
	
	private ConsolidationRule(String value) {
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
