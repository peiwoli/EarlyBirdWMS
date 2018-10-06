/**
 * 
 */
package com.earlybird.wms.base.api.util;

import java.time.Instant;
import java.util.Date;

/**
 * @author Peili Zhou
 *
 */
public class DateTimeUtil {

	/**
	 * 
	 */
	private DateTimeUtil() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 *  Return new {@link Date}
	 * @return
	 */
	public static Date newDate() {
		return Date.from(Instant.now());
	}

}
