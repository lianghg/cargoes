package cargoes.web.configuration.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import com.alibaba.fastjson.util.IOUtils;

@Configuration
public class MvcConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public FastJsonHttpMessageConverter4 fastJsonHttpMessageConverter(){
		
		FastJsonHttpMessageConverter4 fastJsonHttpMessageConverter =new FastJsonHttpMessageConverter4();
		
		FastJsonConfig fastJsonConfig =new FastJsonConfig();
		fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
		fastJsonConfig.setCharset(IOUtils.UTF8);
		
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