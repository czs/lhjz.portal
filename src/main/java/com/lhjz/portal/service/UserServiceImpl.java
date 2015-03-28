/**
 * 立衡脊柱版权所有 (lhjz)
 */
package com.lhjz.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhjz.portal.domain.User;
import com.lhjz.portal.domain.UserRepository;

/**
 * 
 * @author xi
 * 
 * @date 2015年3月28日 下午2:01:22
 * 
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}
}
