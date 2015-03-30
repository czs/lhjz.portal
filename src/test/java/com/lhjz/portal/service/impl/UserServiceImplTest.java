package com.lhjz.portal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.lhjz.portal.entity.User;
import com.lhjz.portal.service.UserService;

public class UserServiceImplTest extends BaseServiceImplTest {

	@Autowired
	UserService userService;

	@Test
	public void save() {
		userService.save(new User("name_xiwc", "password"));
	}
}
