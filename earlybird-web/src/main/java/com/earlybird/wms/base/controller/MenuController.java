package com.earlybird.wms.base.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.earlybird.wms.base.dataloader.DataLoader;
import com.earlybird.wms.base.entity.MenuItem;
import com.earlybird.wms.base.entity.User;
import com.earlybird.wms.base.repository.MenuItemRepository;
import com.earlybird.wms.base.repository.UserRepository;

@RestController
public class MenuController {

	private static Logger logger = LoggerFactory.getLogger(MenuController.class);
	
	@Autowired
	private MenuItemRepository menuItemRepository;
	
	@Autowired
	private UserRepository userRepositoy;
	
	@RequestMapping("/menuList")
    public MenuItem getMenuList() {
		logger.info("getMenuList");
        List<MenuItem> menuList = menuItemRepository.findAllByLevel(0);
        logger.info("peili:{}", menuList.get(0));
        return menuList.get(0);
    }
	
	@GetMapping("/user")
	public User getUser() {
		
		User u = userRepositoy.findAll().iterator().next();
		logger.info("found user :{}", u);
		return u;
		
	}
}
