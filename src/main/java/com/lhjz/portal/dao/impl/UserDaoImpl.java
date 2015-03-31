/**
 * 立衡脊柱版权所有 (lhjz)
 */
package com.lhjz.portal.dao.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
public class UserDaoImpl implements UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	UserRepository userRepository;

	@Override
	public Optional<User> save(User user) {

		entityManager.persist(user);
		entityManager.flush();

		User find = entityManager.find(User.class, user.getId());

		System.out.println(find);

		jdbcTemplate.execute("insert into lhjz.user (name, password) values ('xiwc', 'pwd')");
		
		userRepository.findAll().forEach(System.out::println);

		List<User> users = userRepository.findByName("xiwc");
		
		users.stream().forEach(System.out::println);

		System.out.println("UserDaoImpl.save()");

		return Optional.of(user);
	}
}
