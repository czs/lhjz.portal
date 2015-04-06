/**
 * 立衡脊柱版权所有 (lhjz)
 */
package com.lhjz.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lhjz.portal.base.BaseController;

/**
 * 
 * @author xi
 * 
 * @date 2015年3月28日 下午1:19:05
 * 
 */
@Controller
@RequestMapping("admin")
public class AdminController extends BaseController {

	@RequestMapping("login")
	public String login(Model model) {
		return "admin/login";
	}

	@RequestMapping()
	public String index(Model model) {
		return "admin/index";
	}
}
