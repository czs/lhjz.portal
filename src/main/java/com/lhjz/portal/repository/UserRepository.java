/**
 * 立衡脊柱版权所有 (lhjz)
 */
package com.lhjz.portal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lhjz.portal.entity.User;

/**
 * 
 * @author xi
 * 
 * @date 2015年3月28日 下午2:09:06
 * 
 */
public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findByUsername(String username);
}
