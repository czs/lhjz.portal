/**
 * 立衡脊柱版权所有 (lhjz)
 */
package com.lhjz.portal.dao.impl;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lhjz.portal.base.BaseDao;
import com.lhjz.portal.dao.UserDao;
import com.lhjz.portal.entity.User;
import com.lhjz.portal.repository.UserRepository;

/**
 * 
 * @author xi
 * 
 * @date 2015年3月30日 下午10:00:55
 * 
 */
@Repository
public class UserDaoImpl extends BaseDao implements UserDao {

	static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	@Autowired
	UserRepository userRepository;

	@Override
	public Optional<User> save(User user) {

		String message = messageSource.getMessage("M0001", new Object[] { "Save User" }, Locale.getDefault());

		logger.info(message);

		entityManager.persist(user);
		entityManager.flush();

		User find = entityManager.find(User.class, user.getId());

		logger.info(find.toString());

		jdbcTemplate.execute("insert into lhjz.user (name, password) values ('xiwc', 'pwd')");

		userRepository.findAll().forEach(System.out::println);

		List<User> users = userRepository.findByName("xiwc");

		users.stream().forEach(u -> logger.info(u.toString()));

		logger.info("UserDaoImpl.save()");

		return Optional.of(user);
	}
}
