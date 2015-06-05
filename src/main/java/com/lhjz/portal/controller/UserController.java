/**
 * 立衡脊柱版权所有 (lhjz)
 */
package com.lhjz.portal.controller;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lhjz.portal.base.BaseController;
import com.lhjz.portal.entity.security.Authority;
import com.lhjz.portal.entity.security.AuthorityId;
import com.lhjz.portal.entity.security.User;
import com.lhjz.portal.model.RespBody;
import com.lhjz.portal.pojo.Enum.Action;
import com.lhjz.portal.pojo.Enum.Role;
import com.lhjz.portal.pojo.Enum.Target;
import com.lhjz.portal.pojo.UserForm;
import com.lhjz.portal.repository.AuthorityRepository;
import com.lhjz.portal.repository.UserRepository;
import com.lhjz.portal.util.StringUtil;
import com.lhjz.portal.util.WebUtil;

/**
 * 
 * @author xi
 * 
 * @date 2015年3月28日 下午1:19:05
 * 
 */
@Controller
@RequestMapping("admin/user")
public class UserController extends BaseController {

	static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserRepository userRepository;

	@Autowired
	AuthorityRepository authorityRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	@Secured({ "ROLE_ADMIN" })
	public RespBody save(@Valid UserForm userForm, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return RespBody.failed(bindingResult.getAllErrors().stream()
					.map(err -> err.getDefaultMessage())
					.collect(Collectors.joining("<br/>")));
		}

		// save username and password
		User user = new User();
		user.setUsername(userForm.getUsername());
		user.setPassword(passwordEncoder.encode(userForm.getPassword()));
		user.setEnabled(true);

		userRepository.saveAndFlush(user);

		log(Action.Create, Target.User, user);

		// save default authority `ROLE_USER`
		Authority authority = new Authority();
		authority.setId(new AuthorityId(userForm.getUsername(), Role.ROLE_USER
				.name()));

		authorityRepository.saveAndFlush(authority);

		log(Action.Create, Target.Authority, authority);

		return RespBody.succeed(user);
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ResponseBody
	@Secured({ "ROLE_ADMIN" })
	public RespBody update(UserForm userForm) {

		User user = userRepository.findOne(userForm.getUsername());

		if (user == null) {
			logger.error("更新用户不存在! ID: {}", userForm.getUsername());
			return RespBody.failed("更新用户不存在!");
		}

		if (StringUtil.isNotEmpty(userForm.getPassword())) {
			user.setPassword(passwordEncoder.encode(userForm.getPassword()));
		}

		if (userForm.getEnabled() != null) {
			user.setEnabled(userForm.getEnabled());
		}

		userRepository.saveAndFlush(user);

		return RespBody.succeed(user);
	}

	@RequestMapping(value = "update2", method = RequestMethod.POST)
	@ResponseBody
	@Secured({ "ROLE_USER" })
	public RespBody update2(UserForm userForm) {

		if (!WebUtil.getUsername().equals(userForm.getUsername())) {
			logger.error("普通用户无权限修改其他用户信息!");
			return RespBody.failed("普通用户无权限修改其他用户信息!");
		}

		User user = userRepository.findOne(userForm.getUsername());

		if (user == null) {
			logger.error("更新用户不存在! ID: {}", userForm.getUsername());
			return RespBody.failed("更新用户不存在!");
		}

		if (StringUtil.isNotEmpty(userForm.getPassword())) {
			user.setPassword(passwordEncoder.encode(userForm.getPassword()));
		}

		if (userForm.getEnabled() != null) {
			user.setEnabled(userForm.getEnabled());
		}

		userRepository.saveAndFlush(user);

		return RespBody.succeed(user);
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@ResponseBody
	@Secured({ "ROLE_ADMIN" })
	public RespBody delete(@RequestParam("username") String username) {

		User user = userRepository.findOne(username);

		if (user == null) {
			logger.error("删除用户不存在! ID: {}", username);
			return RespBody.failed("删除用户不存在!");
		}

		userRepository.delete(user);

		return RespBody.succeed(user);
	}

	@RequestMapping(value = "get", method = RequestMethod.POST)
	@ResponseBody
	@Secured({ "ROLE_ADMIN" })
	public RespBody get(@RequestParam("username") String username) {

		User user = userRepository.findOne(username);

		if (user == null) {
			logger.error("查询用户不存在! ID: {}", username);
			return RespBody.failed("查询用户不存在!");
		}

		return RespBody.succeed(user);
	}
}
