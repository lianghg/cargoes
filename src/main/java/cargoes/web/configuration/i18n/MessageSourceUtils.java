package cargoes.web.configuration.i18n;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MessageSourceUtils {

	private static MessageSource messageSource;

	public static String getMessage(String code) {

		return getMessage(code, null);

	}

	public static String getMessage(String code, Object[] args) {

		return getMessage(code, args, "");

	}

	public static String getMessage(String code, Object[] args, String defaultMessage) {
		
		return messageSource.getMessage(code, args, defaultMessage, LocaleContextHolder.getLocale());

	}
	
	@Autowired
    public void setMessageSource(MessageSource messageSource) {  
		MessageSourceUtils.messageSource = messageSource;  
    } 

}