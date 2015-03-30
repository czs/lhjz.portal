/**
 * 立衡脊柱版权所有 (lhjz)
 */
package com.lhjz.portal.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lhjz.portal.dao.UserDao;
import com.lhjz.portal.entity.User;

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

	@Override
	public void save(User user) {

		jdbcTemplate
				.execute("insert into lhjz.user (name, password) values ('xiwc', 'pwd')");

		System.out
				.println("insert into lhjz.user (name, password) values ('xiwc', 'pwd')");
	}
}
