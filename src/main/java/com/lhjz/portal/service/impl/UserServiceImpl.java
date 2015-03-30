/**
 * 立衡脊柱版权所有 (lhjz)
 */
package com.lhjz.portal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}
}
