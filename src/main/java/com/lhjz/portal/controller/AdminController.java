/**
 * 立衡脊柱版权所有 (lhjz)
 */
package com.lhjz.portal.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lhjz.portal.base.BaseController;
import com.lhjz.portal.entity.Settings;
import com.lhjz.portal.pojo.Enum.Module;
import com.lhjz.portal.pojo.Enum.Page;
import com.lhjz.portal.pojo.Enum.Status;
import com.lhjz.portal.repository.DiagnoseRepository;
import com.lhjz.portal.repository.FileRepository;
import com.lhjz.portal.repository.SettingsRepository;
import com.lhjz.portal.repository.UserRepository;
import com.lhjz.portal.util.StringUtil;

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

	static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	FileRepository fileRepository;

	@Autowired
	SettingsRepository settingsRepository;

	@Autowired
	DiagnoseRepository diagnoseRepository;

	@Autowired
	UserRepository userRepository;

	@RequestMapping("login")
	public String login(Model model) {

		logger.debug("Enter method: {}", "login");

		return "admin/login";
	}

	@RequestMapping()
	public String home(Model model) {

		List<Settings> settings = settingsRepository.findByPage(Page.Index);

		List<Settings> bigImgs = new ArrayList<Settings>();
		List<Settings> hotNews = new ArrayList<Settings>();
		List<Settings> moreNews = new ArrayList<Settings>();

		for (Settings settings2 : settings) {
			if (settings2.getModule() == Module.BigImg) {
				bigImgs.add(settings2);
			} else if (settings2.getModule() == Module.HotNews) {
				hotNews.add(settings2);
			} else if (settings2.getModule() == Module.MoreNews) {
				moreNews.add(settings2);
			}
		}

		model.addAttribute("bigImgs", bigImgs);
		model.addAttribute("hotNews", hotNews);
		model.addAttribute("moreNews", moreNews);

		return "admin/index";
	}

	// @RequestMapping("index")
	// public String index(Model model) {
	//
	// return "admin/index";
	// }

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
	public String diagnose(Model model,
			@RequestParam(value = "status", required = false) String status) {

		if (StringUtil.isEmpty(status)) {
			model.addAttribute("diagnoses", diagnoseRepository.findAll());
		} else {

			Status sts = null;

			switch (status) {
			case "new":
				sts = Status.New;
				break;
			case "ignored":
				sts = Status.Ignored;
				break;
			case "resolved":
				sts = Status.Resolved;
				break;
			default:
				logger.error("查询状态对象不存在! status: {}", status);
				sts = Status.Unknow;
				break;
			}

			model.addAttribute("diagnoses",
					diagnoseRepository.findByStatus(sts));
		}

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

	@RequestMapping("user")
	@Secured("ROLE_ADMIN")
	public String user(Model model) {

		logger.debug("Enter method...");

		model.addAttribute("users", userRepository.findAll());

		return "admin/user";
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

	@RequestMapping("feedback")
	public String feedback(Model model) {
		return "admin/feedback";
	}
}
