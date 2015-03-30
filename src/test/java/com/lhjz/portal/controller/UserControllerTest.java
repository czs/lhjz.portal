package com.lhjz.portal.controller;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.lhjz.portal.entity.User;

public class UserControllerTest extends BaseControllerTest {

	@Test
	public void register() {
		User user = template.postForObject(url("user/register"), null,
				User.class);
		assertThat(user, Matchers.notNullValue(User.class));
	}
}
