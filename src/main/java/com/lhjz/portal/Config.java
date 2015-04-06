/**
 * 立衡脊柱版权所有 (lhjz)
 */
package com.lhjz.portal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 
 * @author xi
 * 
 * @date 2015年3月30日 下午9:42:00
 * 
 */
@Configuration
public class Config {

	// @Bean
	// public RequestDataValueProcessor csrfRequestDataValueProcessorBean() {
	// return new CsrfRequestDataValueProcessor();
	// }

	@Configuration
	@EnableWebSecurity
	public static class SecurityConfiguration extends
			WebSecurityConfigurerAdapter {

		@Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth)
				throws Exception {
			auth.inMemoryAuthentication().withUser("xiwc").password("xiwc")
					.roles("ADMIN");
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
					.and().formLogin().loginPage("/admin/login").permitAll()
					.defaultSuccessUrl("/admin").and().logout()
					.logoutUrl("/admin/logout")
					.logoutSuccessUrl("/admin/login");
		}

	}

}
