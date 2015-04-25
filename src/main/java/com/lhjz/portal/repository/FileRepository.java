/**
 * 立衡脊柱版权所有 (lhjz)
 */
package com.lhjz.portal.repository;

import org.springframework.data.repository.CrudRepository;

import com.lhjz.portal.entity.File;

/**
 * 
 * @author xi
 * 
 * @date 2015年3月28日 下午2:09:06
 * 
 */
public interface FileRepository extends CrudRepository<File, Long> {

	File findTopByUuid(String uuid);
}
