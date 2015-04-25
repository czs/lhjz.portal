/**
 * 立衡脊柱版权所有 (lhjz)
 */
package com.lhjz.portal.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 
 * @author xi
 * 
 * @date 2015年3月30日 下午9:42:00
 * 
 */
@Configuration
@EnableWebMvcSecurity
public class SecurityConfig {

	@Autowired
	DataSource dataSource;

	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoderBean() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource)
				.passwordEncoder(bCryptPasswordEncoderBean());
	}

	@Configuration
	@Order(1)
	public static class SecurityConfiguration extends
			WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {

			http.antMatcher("/admin/**")
					.authorizeRequests()
					.antMatchers("/admin/css/**", "/admin/img/**",
							"/admin/js/**").permitAll().anyRequest()
					.authenticated().and().formLogin()
					.loginPage("/admin/login").permitAll()
					.loginProcessingUrl("/admin/signin")
					.defaultSuccessUrl("/admin/index").and().logout()
					.logoutUrl("/admin/logout")
					.logoutSuccessUrl("/admin/login");

		}

	}

}