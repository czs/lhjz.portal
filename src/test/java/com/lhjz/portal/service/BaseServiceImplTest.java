/**
 * 立衡脊柱版权所有 (lhjz)
 */
package com.lhjz.portal.service;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import com.lhjz.portal.Application;

/**
 * 
 * @author xi
 * 
 * @date 2015年3月28日 下午7:54:29
 * 
 */
@SpringApplicationConfiguration(classes = Application.class)
public abstract class BaseServiceImplTest extends
		AbstractTestNGSpringContextTests {

}
