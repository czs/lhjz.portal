/**
 * 立衡脊柱版权所有 (lhjz)
 */
package com.lhjz.portal;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

/**
 * 
 * @author xi
 * 
 * @date 2015年3月30日 下午9:42:00
 * 
 */
@Configuration
public class Config {

	@Configuration
	@EnableWebMvcSecurity
	public static class SecurityConfiguration extends WebSecurityConfigurerAdapter {

		@Autowired
		DataSource dataSource;

		@Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
			// auth.inMemoryAuthentication().withUser("xiwc").password("xiwc").roles("ADMIN");

			auth.jdbcAuthentication().dataSource(dataSource);
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {

			http.antMatcher("/admin/**").authorizeRequests().antMatchers("/admin/login*").permitAll().anyRequest()
					.hasRole("ADMIN").and().formLogin().loginPage("/admin/login").loginProcessingUrl("/admin/signin")
					.defaultSuccessUrl("/admin/index").and().logout().logoutUrl("/admin/logout")
					.logoutSuccessUrl("/admin/login").and().httpBasic();

		}

	}

}
