package cargoes.web.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.session.SimpleRedirectInvalidSessionStrategy;

import cargoes.web.mvc.MvcConfiguration;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomAuthenticationProvider customAuthenticationProvider;

	@Autowired
	private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
	
	@Autowired
	private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;
	
	@Autowired
	private AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> authenticationDetailsSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.authenticationProvider(customAuthenticationProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		
		//url拦截配置
		http.authorizeRequests()//
			.antMatchers("/verifyCodeImage").permitAll()//验证码
			.antMatchers("/changeLanauage").permitAll()//切换语言
			.antMatchers("/authentication").permitAll()//
//			.antMatchers("/swagger*/**").permitAll()//api文档
//			.antMatchers("/druid/**").permitAll()//druid监控
			.anyRequest().authenticated();//其它链接地址认证后授权访问
		
		// 登录流程配置
		http.formLogin()//
			.authenticationDetailsSource(authenticationDetailsSource)//
			.loginPage(MvcConfiguration.LOGIN_PAGE_URL)//
			.loginProcessingUrl(MvcConfiguration.LOGIN_URL)//
			.successHandler(customAuthenticationSuccessHandler)//和defaultSuccessUrl功能相同，但可以定制流程
			.failureHandler(customAuthenticationFailureHandler)//和failureUrl功能相同，但可以定制流程
			.permitAll();//
			
		//注销流程配置
		http.logout()//
			.logoutUrl(MvcConfiguration.LOGOUT_URL)//
			.logoutSuccessUrl(MvcConfiguration.LOGOUT_SUCCESS_URL)//
			.clearAuthentication(true)//
			.deleteCookies("JSESSIONID")//
			.permitAll();
		
		//session管理
		http.sessionManagement()//session 管理
			.sessionFixation().migrateSession()//创建一个新session，把原来session中所有属性复制到新session中
			.invalidSessionStrategy(new SimpleRedirectInvalidSessionStrategy(MvcConfiguration.LOGIN_PAGE_URL))// session过期后跳转到指定地址
			.maximumSessions(1)// 同一账号只有一个在线实例
			.maxSessionsPreventsLogin(false);// true:拒绝第二次登录，false:把之前的挤下线
			
	}

}

