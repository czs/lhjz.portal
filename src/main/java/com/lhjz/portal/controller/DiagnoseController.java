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

import com.lhjz.portal.base.BaseController;
import com.lhjz.portal.component.MailSender;
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

}
