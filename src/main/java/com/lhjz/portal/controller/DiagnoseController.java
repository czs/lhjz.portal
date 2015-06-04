/**
 * 立衡脊柱版权所有 (lhjz)
 */
package com.lhjz.portal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lhjz.portal.base.BaseController;
import com.lhjz.portal.component.MailSender;
import com.lhjz.portal.entity.Diagnose;
import com.lhjz.portal.model.RespBody;
import com.lhjz.portal.pojo.Enum.Action;
import com.lhjz.portal.pojo.Enum.Status;
import com.lhjz.portal.pojo.Enum.Target;
import com.lhjz.portal.repository.DiagnoseRepository;

/**
 * 
 * @author xi
 * 
 * @date 2015年3月28日 下午1:19:05
 * 
 */
@Controller
@RequestMapping("admin/diagnose")
public class DiagnoseController extends BaseController {

	static final Logger logger = LoggerFactory
			.getLogger(DiagnoseController.class);

	@Autowired
	MailSender mailSender;

	@Value("${lhjz.mail.switch}")
	private String mailSwitch;

	@Autowired
	DiagnoseRepository diagnoseRepository;

	@RequestMapping("list")
	@ResponseBody
	public RespBody list() {

		logger.debug("Enter method...");

		return RespBody.succeed(diagnoseRepository.findAll());
	}

	@RequestMapping("update")
	@ResponseBody
	public RespBody update(
			@RequestParam(value = "id", required = true) Long id, String status) {

		logger.debug("Enter method...");

		Diagnose diagnose = diagnoseRepository.findOne(id);

		// Ignored Resolved
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
			logger.error("更新状态不存在! status: {}", status);
			return RespBody.failed("更新状态不存在!");
		}

		diagnose.setStatus(sts);

		Diagnose diagnose2 = diagnoseRepository.saveAndFlush(diagnose);

		logWithProperties(Action.Update, Target.Diagnose, "status", status);

		return RespBody.succeed(diagnose2);
	}

	@RequestMapping("delete")
	@ResponseBody
	public RespBody delete(@RequestParam(value = "id", required = true) Long id) {

		logger.debug("Enter method...");

		Diagnose diagnose = diagnoseRepository.findOne(id);

		if (diagnose == null) {
			logger.error("删除对象不存在! ID: {}", id);
			return RespBody.failed("删除对象不存在!");
		}

		diagnoseRepository.delete(diagnose);

		log(Action.Delete, Target.Diagnose, diagnose);

		return RespBody.succeed(id);
	}
}
