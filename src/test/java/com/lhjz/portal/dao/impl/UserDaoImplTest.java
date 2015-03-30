package com.lhjz.portal.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.lhjz.portal.dao.UserDao;
import com.lhjz.portal.entity.User;

public class UserDaoImplTest extends BaseDaoImplTest {

	@Autowired
	UserDao userDao;

	@Test
	public void save() {
		userDao.save(new User("name_xiwc", "password"));
	}
}
