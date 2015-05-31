/**
 * 立衡脊柱版权所有 (lhjz)
 */
package com.lhjz.portal.controller;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lhjz.portal.base.BaseController;
import com.lhjz.portal.entity.Settings;
import com.lhjz.portal.model.RespBody;
import com.lhjz.portal.pojo.Enum.Action;
import com.lhjz.portal.pojo.Enum.Target;
import com.lhjz.portal.pojo.SettingsForm;
import com.lhjz.portal.repository.SettingsRepository;
import com.lhjz.portal.util.WebUtil;

/**
 * 
 * @author xi
 * 
 * @date 2015年3月28日 下午1:19:05
 * 
 */
@Controller
@RequestMapping("admin/settings")
public class SettingsController extends BaseController {

	static final Logger logger = LoggerFactory
			.getLogger(SettingsController.class);

	@Autowired
	SettingsRepository settingsRepository;

	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public RespBody save(@Valid SettingsForm settingsForm,
			BindingResult bindingResult) {

		logger.debug("Enter method: {}", "save");

		if (bindingResult.hasErrors()) {
			return RespBody.failed(bindingResult.getAllErrors().stream()
					.map(err -> err.getDefaultMessage())
					.collect(Collectors.joining("<br/>")));
		}

		Settings settings = new Settings();
		settings.setPage(settingsForm.page());
		settings.setModule(settingsForm.module());
		settings.setImgUrl(settingsForm.getImgUrl());
		settings.setUsername(WebUtil.getUsername());

		Settings settings2 = settingsRepository.save(settings);

		log(Action.Create, Target.Settings, settings2);

		return RespBody.succeed(settings2);
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@ResponseBody
	public RespBody delete(@RequestParam(value = "id", required = true) Long id) {

		logger.debug("Enter method: {}", "delete");

		settingsRepository.delete(id);

		log(Action.Delete, Target.Settings, id);

		return RespBody.succeed(id);
	}

}
