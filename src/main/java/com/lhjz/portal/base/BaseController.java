/**
 * 立衡脊柱版权所有 (lhjz)
 */
package com.lhjz.portal.base;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhjz.portal.entity.Log;
import com.lhjz.portal.pojo.Enum.Action;
import com.lhjz.portal.pojo.Enum.Target;
import com.lhjz.portal.repository.LogRepository;
import com.lhjz.portal.util.WebUtil;

/**
 * 
 * @author weichx
 * 
 * @date Apr 2, 2015 2:59:47 PM
 * 
 */
public abstract class BaseController {

	@Autowired
	LogRepository logRepository;

	protected Log log(Action action, Target target, Object... vals) {

		Log log = new Log();
		log.setAction(action);
		log.setTarget(target);
		log.setCreateDate(new Date());

		if (vals.length > 0) {
			log.setNewValue(String.valueOf(vals[0]));
		}

		if (vals.length > 1) {
			log.setOldValue(String.valueOf(vals[1]));
		}

		log.setUsername(WebUtil.getUsername());

		return logRepository.saveAndFlush(log);

	}
}
