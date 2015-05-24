/**
 * 立衡脊柱版权所有 (lhjz)
 */
package com.lhjz.portal.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lhjz.portal.base.BaseController;
import com.lhjz.portal.component.MailSender;
import com.lhjz.portal.entity.Feedback;
import com.lhjz.portal.model.RespBody;
import com.lhjz.portal.pojo.Enum.Action;
import com.lhjz.portal.pojo.Enum.Target;
import com.lhjz.portal.pojo.FeedbackForm;
import com.lhjz.portal.repository.FeedbackRepository;
import com.lhjz.portal.util.ThreadUtil;
import com.lhjz.portal.util.WebUtil;

/**
 * 
 * @author xi
 * 
 * @date 2015年3月28日 下午1:19:05
 * 
 */
@Controller
@RequestMapping("admin/feedback")
public class FeedbackController extends BaseController {

	static final Logger logger = LoggerFactory
			.getLogger(FeedbackController.class);

	@Autowired
	FeedbackRepository feedbackRepository;

	@Autowired
	MailSender mailSender;

	@Autowired
	Environment env;

	@Value("${lhjz.mail.switch}")
	private String mailSwitch;

	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public RespBody save(@Valid FeedbackForm feedbackForm,
			BindingResult bindingResult) {

		logger.debug("Enter method: {}", "save");

		if (bindingResult.hasErrors()) {
			return RespBody.failed(bindingResult.getAllErrors().stream()
					.map(err -> err.getDefaultMessage())
					.collect(Collectors.joining("<br/>")));
		}

		List<Feedback> feedbacks = feedbackRepository.findByContentAndUsername(
				feedbackForm.getContent(), WebUtil.getUsername());

		if (feedbacks.size() > 0) {
			return RespBody.failed("您已经反馈过该内容！");
		}

		Feedback feedback = new Feedback();
		feedback.setContent(feedbackForm.getContent());
		feedback.setCreateDate(new Date());
		feedback.setMail(feedbackForm.getMail());
		feedback.setName(feedbackForm.getName());
		feedback.setPhone(feedbackForm.getPhone());
		feedback.setUsername(WebUtil.getUsername());
		feedback.setUrl(feedbackForm.getUrl());

		final Feedback feedback2 = feedbackRepository.saveAndFlush(feedback);

		log(Action.Create, Target.Feedback, feedback2);

		ThreadUtil.exec(() -> {
			if (mailSender.sendText("立恒脊柱(LHJZ)用户反馈", feedback2.toString())) {
				logger.info("反馈邮件发送成功！ID:{}", feedback2.getId());
			} else {
				logger.error("反馈邮件发送失败！ID:{}", feedback2.getId());
			}
		});

		return RespBody.succeed("反馈提交成功，谢谢！");
	}

}