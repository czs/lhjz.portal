/**
 * 立衡脊柱版权所有 (lhjz)
 */
package com.lhjz.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lhjz.portal.base.BaseController;
import com.lhjz.portal.service.UserService;

/**
 * 
 * @author xi
 * 
 * @date 2015年3月28日 下午1:19:05
 * 
 */
@Controller
@RequestMapping("test")
public class TestController extends BaseController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "test", method = { RequestMethod.GET })
	public String test(Model model) {
		model.addAttribute("users", userService.getAll());
		return "test";
	}
}
