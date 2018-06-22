package cargoes.util;

import java.util.Locale;

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

	public static String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {

		return messageSource.getMessage(code, args, defaultMessage, locale);

	}

	public static String analyseMsg(String keys, Locale local) {

		String target = "";

		if (keys != null && keys != "") {
			String[] msgs = keys.trim().split(",");
			if (msgs != null && msgs.length > 0) {
				for (String key : msgs) {
					System.out.println(key.trim());
					target += "," + messageSource.getMessage(key.trim(), null, "", local);
				}

				target = target.substring(1, target.length());
			}
		}

		return target;

	}

	public static String analyseMsg(String keys) {

		String target = "";

		if (keys != null && keys != "") {
			String[] msgs = keys.trim().split(",");
			if (msgs != null && msgs.length > 0) {
				for (String key : msgs) {
					System.out.println(key.trim());
					target += "," + messageSource.getMessage(key.trim(), null, "", LocaleContextHolder.getLocale());
				}

				target = target.substring(1, target.length());
			}
		}

		return target;

	}

	@Autowired
	public void setMessageSource(MessageSource messageSource) {
		MessageSourceUtils.messageSource = messageSource;
	}

}