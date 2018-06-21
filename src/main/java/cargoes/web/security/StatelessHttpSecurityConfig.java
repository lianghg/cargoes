package cargoes.web.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import cargoes.web.configuration.security.JWTFilter.JWTAuthenticationFilter;
import cargoes.web.configuration.security.JWTFilter.JWTLoginFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class StatelessHttpSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomAuthenticationProvider customAuthenticationProvider;

	@Autowired
	private AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> authenticationDetailsSource;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//用户认证类
		auth.authenticationProvider(customAuthenticationProvider);
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		
		String[] permitAll = { //
				"/druid/**", // druid监控
				"/swagger*/**", // api文档
				"/getVerifyCodeImage", // 验证码图片
				"/vueDemo", //test
				"/user/**", //test
				"/role/**", //test
				"/department/**"//test
		};
//		http.headers().cacheControl();
		
		http.cors().and().csrf().disable()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        .authorizeRequests()
        .antMatchers(permitAll).permitAll()
        .anyRequest().authenticated()  // 所有请求需要身份认证
        .and()
        .addFilter(new JWTLoginFilter(authenticationManager()))
        .addFilter(new JWTAuthenticationFilter(authenticationManager()))
        ;
	}
}
