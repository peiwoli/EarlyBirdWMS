/**
 * 
 */
package com.earlybird.wms.base.api.service;

import java.util.List;

import com.earlybird.wms.base.entity.MenuItem;
import com.earlybird.wms.base.entity.User;

/**
 * @author Peili Zhou
 *
 */
public interface MenuService extends BaseService {

	/**
	 * Based on role permission, find all top menu items
	 * @param user
	 * @return menuItem entities
	 */
	List<MenuItem> findTopMenuItems(User user);
	
	/**
	 * Based on user's role permissions, find all title levels of menu items 
	 * @param user
	 * @return menuItem lists
	 */
	List<MenuItem> findPanelTitleMenuItems(User user);
	
	/**
	 * 
	 * @param user user
	 * @param parentMenuItem parent menu item
	 * @return sub menu items
	 */
	List<MenuItem> findSubMenuItemsByParent(User user, MenuItem parentMenuItem);
}
