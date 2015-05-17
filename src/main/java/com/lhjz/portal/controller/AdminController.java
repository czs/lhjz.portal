/**
 * 立衡脊柱版权所有 (lhjz)
 */
package com.lhjz.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lhjz.portal.base.BaseController;
import com.lhjz.portal.repository.FileRepository;

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

	@Autowired
	FileRepository fileRepository;

	@Autowired
	Environment env;

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

		String storePath = env.getProperty("lhjz.upload.img.store.path");
		int sizeLarge = env.getProperty("lhjz.upload.img.scale.size.large",
				Integer.class);
		int sizeHuge = env.getProperty("lhjz.upload.img.scale.size.huge",
				Integer.class);
		int sizeOriginal = env.getProperty(
				"lhjz.upload.img.scale.size.original", Integer.class);

		// img relative path (eg:'upload/img/' & 640 & '/' )
		model.addAttribute("path", storePath + sizeOriginal + "/");
		model.addAttribute("pathLarge", storePath + sizeLarge + "/");
		model.addAttribute("pathHuge", storePath + sizeHuge + "/");
		// list all files
		model.addAttribute("imgs", fileRepository.findAll());

		return "admin/resource";
	}

	@RequestMapping("article")
	public String article(Model model) {
		return "admin/article";
	}
}
