/**
 * 立衡脊柱版权所有 (lhjz)
 */
package com.lhjz.portal.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lhjz.portal.base.BaseController;
import com.lhjz.portal.entity.Diagnose;
import com.lhjz.portal.entity.Settings;
import com.lhjz.portal.model.RespBody;
import com.lhjz.portal.pojo.DiagnoseForm;
import com.lhjz.portal.pojo.Enum.Action;
import com.lhjz.portal.pojo.Enum.Module;
import com.lhjz.portal.pojo.Enum.Page;
import com.lhjz.portal.pojo.Enum.Target;
import com.lhjz.portal.repository.DiagnoseRepository;
import com.lhjz.portal.repository.SettingsRepository;
import com.lhjz.portal.util.StringUtil;

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

	static final Logger logger = LoggerFactory.getLogger(RootController.class);

	@Autowired
	DiagnoseRepository diagnoseRepository;

	@Autowired
	SettingsRepository settingsRepository;

	@RequestMapping()
	public String home(HttpServletRequest request, Model model) {

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

		logWithProperties(Action.Visit, Target.Page, Page.Index.name(),
				request.getRemoteAddr());

		return "landing/index";
	}

	// @RequestMapping("index")
	// public String index(Model model) {
	// return "landing/index";
	// }

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

	@RequestMapping("job")
	public String job(Model model) {
		return "landing/job";
	}

	@RequestMapping(value = "diagnose/save", method = RequestMethod.POST)
	@ResponseBody
	public RespBody save(@Valid DiagnoseForm diagnoseForm,
			BindingResult bindingResult) {

		logger.debug("Enter method: {}", "save");

		if (bindingResult.hasErrors()) {
			return RespBody.failed(bindingResult.getAllErrors().stream()
					.map(err -> err.getDefaultMessage())
					.collect(Collectors.joining("<br/>")));
		}

		if (StringUtil.isEmpty(diagnoseForm.getMail())
				&& StringUtil.isEmpty(diagnoseForm.getPhone())) {
			return RespBody.failed("手机或者邮箱必须填写一个。");
		}

		if (StringUtil.isNotEmpty(diagnoseForm.getMail())
				&& !StringUtil.isEmail(diagnoseForm.getMail())) {
			return RespBody.failed("邮箱格式输入不正确，请核对后输入！");
		}

		if (StringUtil.isNotEmpty(diagnoseForm.getPhone())
				&& !StringUtil.isMobile(diagnoseForm.getPhone())) {
			return RespBody.failed("手机号格式输入不正确，请核对后输入！");
		}

		if (StringUtil.isNotEmpty(diagnoseForm.getMail())) {
			List<Diagnose> diagnoses = diagnoseRepository
					.findByMailAndDescription(diagnoseForm.getMail(),
							diagnoseForm.getDescription());
			if (diagnoses.size() > 0) {
				return RespBody.failed("您你症状描述已经存在，不能重复提交！");
			}
		}

		if (StringUtil.isNotEmpty(diagnoseForm.getPhone())) {
			List<Diagnose> diagnoses = diagnoseRepository
					.findByPhoneAndDescription(diagnoseForm.getPhone(),
							diagnoseForm.getDescription());
			if (diagnoses.size() > 0) {
				return RespBody.failed("您你症状描述已经存在，不能重复提交！");
			}
		}

		Diagnose diagnose = new Diagnose();
		diagnose.setMail(diagnoseForm.getMail());
		diagnose.setPhone(diagnoseForm.getPhone());
		diagnose.setDescription(diagnoseForm.getDescription());
		diagnose.setCreateDate(new Date());

		Diagnose diagnose2 = diagnoseRepository.save(diagnose);

		log(Action.Create, Target.Diagnose, diagnose2);

		return RespBody.succeed("在线诊断提交成功，我们将尽快给予您回复！");
	}
}
