/**
 * 立衡脊柱版权所有 (lhjz)
 */
package com.lhjz.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping()
public class RootController extends BaseController {

	@Autowired
	UserService userService;

	@RequestMapping()
	public String home(Model model) {
		return "landing/index";
	}

	@RequestMapping("index")
	public String index(Model model) {
		return "landing/index";
	}

	@RequestMapping("about")
	public String about(Model model) {
		return "landing/about";
	}

	@RequestMapping("case")
	public String cases(Model model) {
		return "landing/case";
	}

	@RequestMapping("team")
	public String team(Model model) {
		return "landing/team";
	}

	@RequestMapping("diagnose")
	public String diagnose(Model model) {
		return "landing/diagnose";
	}

	@RequestMapping("contact")
	public String contact(Model model) {
		return "landing/contact";
	}

	@RequestMapping("env")
	public String env(Model model) {
		return "landing/env";
	}

	@RequestMapping("feature")
	public String feature(Model model) {
		return "landing/feature";
	}

	@RequestMapping("health")
	public String health(Model model) {
		return "landing/health";
	}

	@RequestMapping("product")
	public String product(Model model) {
		return "landing/product";
	}
}
