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
	public String home(Model model) {
		return "admin/index";
	}

	@RequestMapping("index")
	public String index(Model model) {
		return "admin/index";
	}
	
	@RequestMapping("about")
	public String about(Model model) {
		return "admin/about";
	}
	
	@RequestMapping("case")
	public String case_(Model model) {
		return "admin/case";
	}
	
	@RequestMapping("contact")
	public String contact(Model model) {
		return "admin/contact";
	}
	
	@RequestMapping("diagnose")
	public String diagnose(Model model) {
		return "admin/diagnose";
	}
	
	@RequestMapping("env")
	public String env(Model model) {
		return "admin/env";
	}
	
	@RequestMapping("feature")
	public String feature(Model model) {
		return "admin/feature";
	}
	
	@RequestMapping("health")
	public String health(Model model) {
		return "admin/health";
	}
	
	@RequestMapping("product")
	public String product(Model model) {
		return "admin/product";
	}
	
	@RequestMapping("team")
	public String team(Model model) {
		return "admin/team";
	}

	@RequestMapping("resource")
	public String resource(Model model) {
		return "admin/resource";
	}
}