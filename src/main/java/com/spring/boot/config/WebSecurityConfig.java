package com.spring.boot.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/", "/account/register" ,"/css/**").permitAll()		// permitAll() 로그인 안해도 접근 가능하게 함
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/account/login")
				.permitAll()
				.and()
			.logout()
				.permitAll();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) 
			throws Exception {	
		auth.jdbcAuthentication()	// 인증 처리
			.dataSource(dataSource)
			.passwordEncoder(passwordEncoder())
			.usersByUsernameQuery("select username, password, enabled "		
								+ "from user "
								+ "where username = ?")
			.authoritiesByUsernameQuery("select u.username, r.name "		// 권한 처리
									  + "from user_role ur inner join user u on ur.user_id = u.id "
									  + "inner join role r on ur.role_id = r.id "
									  + "where u.username = ?");
	}
	/*
	 * 	Authentication 로그인
	 * 	Authorization	권한
	 */
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	
	
	
	/*
	 * 	JPA (여러 테이블 조인할 때 설정 관련)
	 * 	 - @OneToOne		ex) user - user_detail
	 * 	 - @OneToMany		ex)	user - board
	 * 	 - @ManyToOne		ex)	board - user
	 * 	 - @ManyToMany		ex)	user - role
	 */
}