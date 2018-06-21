package cargoes.web.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.session.SimpleRedirectInvalidSessionStrategy;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Value("${app.login.view.url}")
	private String loginViewUrl;
	
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
		
		//url拦截配置
		http.authorizeRequests()//
//			.antMatchers("/test").permitAll()//
			.antMatchers("/getVerifyCodeImage").permitAll()//验证码
			.antMatchers("/api/**").permitAll()//边缘api
			.antMatchers("/swagger*/**").permitAll()//api文档
			.antMatchers("/v2/**").permitAll()//api文档
			.antMatchers("/druid/**").permitAll()//druid监控
			.antMatchers("/user/registerUI").permitAll()//注册界面
			.antMatchers("/user/register").permitAll()//注册
			.antMatchers("/home/**").hasRole("ADMIN")//
			.anyRequest().authenticated();//
		
		// 登录流程配置
		http.formLogin()//
			.authenticationDetailsSource(authenticationDetailsSource)//
			.loginPage(loginViewUrl)//
			.loginProcessingUrl("/login")
			.successHandler(customAuthenticationSuccessHandler)//和defaultSuccessUrl功能相同，但可以定制流程，最后声明的生效，不推荐同时声明
			.failureHandler(customAuthenticationFailureHandler)//和failureUrl功能相同，但可以定制流程，最后声明的生效，不推荐要同时声明
//			.defaultSuccessUrl("/home?name=kate",true)//
//			.failureUrl("/toLogin?error=true")//
			.permitAll();//
			
		//注销流程配置
		http.logout()//
			.logoutUrl("/logout")//
			.logoutSuccessUrl("/toLogin")//
			.clearAuthentication(true)//
			.deleteCookies("JSESSIONID")//
			.permitAll();
		
		http.csrf().disable();
		
		//session管理
		http.sessionManagement()//session 管理
			.sessionFixation().migrateSession()//创建一个新session，把原来session中所有属性复制到新session中
			.invalidSessionStrategy(new SimpleRedirectInvalidSessionStrategy("/toLogin"))// session过期跳转到
			.maximumSessions(1)// 同一账号只有一个在线实例
			.maxSessionsPreventsLogin(false);// true:拒绝第二次登录，false:把之前的挤下线
			
	}

}
