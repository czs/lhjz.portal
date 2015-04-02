/**
 * 立衡脊柱版权所有 (lhjz)
 */
package com.lhjz.portal.service.impl;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lhjz.portal.base.BaseService;
import com.lhjz.portal.dao.UserDao;
import com.lhjz.portal.entity.User;
import com.lhjz.portal.repository.UserRepository;
import com.lhjz.portal.service.UserService;

/**
 * 
 * @author xi
 * 
 * @date 2015年3月28日 下午2:01:22
 * 
 */
@Service
@Transactional
public class UserServiceImpl extends BaseService implements UserService {

	static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserDao userDao;

	@Autowired
	MessageSource messageSource;

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public Iterable<User> getAll() {

		logger.debug(messageSource.getMessage("home.id", null, Locale.getDefault()));

		return userRepository.findAll();
	}
}
