/**
 * 立衡脊柱版权所有 (lhjz)
 */
package com.lhjz.portal.dao;

import java.util.Optional;

import com.lhjz.portal.entity.User;

/**
 * 
 * @author xi
 * 
 * @date 2015年3月30日 下午10:00:33
 * 
 */
public interface UserDao {

	Optional<User> save(User user);
}
