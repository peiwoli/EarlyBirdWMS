/**
 * 
 */
package com.earlybird.wms.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.earlybird.wms.base.api.MenuItemConstants;
import com.earlybird.wms.base.api.service.MenuService;
import com.earlybird.wms.base.entity.MenuItem;
import com.earlybird.wms.base.entity.User;
import com.earlybird.wms.base.repository.MenuItemRepository;

/**
 * @author Peili Zhou
 *
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService {

	@Autowired
	protected MenuItemRepository menuItemRepository;
	
	/**
	 * 
	 */
	public MenuServiceImpl() {
		
	}

	/* (non-Javadoc)
	 * @see com.earlybird.wms.base.api.service.MenuService#findTopMenuItems(com.earlybird.wms.base.entity.User)
	 */
	@Override
	public List<MenuItem> findTopMenuItems(User user) {
		if (user != null) {
			//TOOD: 
		}
		return menuItemRepository.findAllByLevel(MenuItemConstants.TOP_LEVEL);
	}

	/* (non-Javadoc)
	 * @see com.earlybird.wms.base.api.service.MenuService#findPanelTitleMenuItems(com.earlybird.wms.base.entity.User)
	 */
	@Override
	public List<MenuItem> findPanelTitleMenuItems(User user) {
		if (user != null) {
			
		}
		return menuItemRepository.findAllByLevel(MenuItemConstants.GROUP_PANEL_LEVEL);
	}

	/* (non-Javadoc)
	 * @see com.earlybird.wms.base.api.service.MenuService#findSubMenuItemsByParent(com.earlybird.wms.base.entity.User, com.earlybird.wms.base.entity.MenuItem)
	 */
	@Override
	public List<MenuItem> findSubMenuItemsByParent(User user, MenuItem parentMenuItem) {
		if (user != null) {
			
		}
		return menuItemRepository.findAllChildrenByParent(parentMenuItem);
	}

}
