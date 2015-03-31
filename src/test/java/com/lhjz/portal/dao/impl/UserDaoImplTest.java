package com.lhjz.portal.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;

import com.lhjz.portal.base.BaseDaoTest;
import com.lhjz.portal.dao.UserDao;
import com.lhjz.portal.entity.User;

public class UserDaoImplTest extends BaseDaoTest {

	@Autowired
	UserDao userDao;

	@Rollback(false)
	@Test
	public void save() {
		userDao.save(new User("name_xiwc", "password"));
	}
}
