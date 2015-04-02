/**
 * 立衡脊柱版权所有 (lhjz)
 */
package com.lhjz.portal.service;

import com.lhjz.portal.entity.User;

/**
 * 
 * @author xi
 * 
 * @date 2015年3月28日 下午2:26:45
 * 
 */
public interface UserService {

	public User save(User user);

	public Iterable<User> getAll();
}
