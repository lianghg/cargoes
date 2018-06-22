package cargoes.web.configuration.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import com.alibaba.fastjson.util.IOUtils;

@Configuration
public class MvcConfiguration extends WebMvcConfigurerAdapter {

	/** 登录认证地址 **/
	public static final String LOGIN_URL = "/login";

	/** 退出地址 **/
	public static final String LOGOUT_URL = "/logout";

	/** 登录页面地址 **/
	public static final String LOGIN_PAGE_URL = "/authentication";

	/** 登录页面物理名称 **/
	public static final String LOGIN_PAGE_NAME = "login";

	/** 登录成功后跳转到该地址 **/
	public static final String LOGIN_SUCCESS_URL = "/home";

	/** 退出成功后跳转到该地址 **/
	public static final String LOGOUT_SUCCESS_URL = LOGIN_PAGE_URL;

	/** 标识是否显示验证码(在session中的key) **/
	public static final String AUTHENTICATION_SHOW_VERIFYCODE_IMAGE_KEY = "AUTHENTICATION_SHOW_VERIFYCODE_IMAGE_KEY";
	
	/** 认证失败次数-在session中的key **/
	public static final String AUTHENTICATION_FAILURE_COUNT = "AUTHENTICATION_FAILURE_COUNT";

	/** 认证失败次数达到该值就要求写验证码,当值小于1时表示总是要填写验证码 **/
	public static final Integer AUTHENTICATION_FAILURE_COUNT_ALLOWED_VALUE = 3;
	
	/** 是否开启登录验证码 **/
	public static final boolean AUTHENTICATION_VERIFYCODE_ENABLED = false;

	
	/** 国际化配置：语言参数 **/
	@Bean  
    public LocaleResolver localeResolver() {  
        SessionLocaleResolver slr = new SessionLocaleResolver();  
        slr.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
        return slr;  
    }  

    @Bean  
    public LocaleChangeInterceptor localeChangeInterceptor() {  
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();  
        lci.setParamName("lang");  
        return lci;  
    }  

    @Override  
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor()); 
    } 

	@Bean
	public FastJsonHttpMessageConverter4 fastJsonHttpMessageConverter() {

		FastJsonHttpMessageConverter4 fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter4();

		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
		fastJsonConfig.setCharset(IOUtils.UTF8);
		fastJsonConfig.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect);

		List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
		supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
		supportedMediaTypes.add(MediaType.TEXT_HTML);

		fastJsonHttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
		fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
		return fastJsonHttpMessageConverter;
	}

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

		converters.add(fastJsonHttpMessageConverter());
	}

}