/**
 * 
 */
package com.earlybird.wms.base.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.earlybird.wms.base.entity.MenuItem;


/**
 * @author Peili Zhou
 * @param <MenuItem>
 *
 */
@Repository
public interface MenuItemRepository extends BaseRepository<MenuItem, Long> {

	/**
	 * 
	 * @param level
	 * @return
	 */
	List<MenuItem> findAllByLevel(Integer level);
	
	
	/**
	 * 
	 * @param menuItem
	 * @return
	 */
	List<MenuItem> findAllChildrenByParent(MenuItem menuItem);
	
}
