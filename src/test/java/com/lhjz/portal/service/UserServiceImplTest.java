package com.lhjz.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.lhjz.portal.domain.User;

public class UserServiceImplTest extends BaseServiceImplTest {

	@Autowired
	UserService userService;

	@Test
	public void save() {
		userService.save(new User("name_xiwc", "password"));
	}
}
