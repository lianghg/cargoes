package cargoes.web.security;

import java.io.UnsupportedEncodingException;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

public final class PasswordUtil {

	public static byte[] wrapStringToByte(String msg) {

		return wrapStringToByte(msg, "UTF-8");
	}

	public static byte[] wrapStringToByte(String msg, String chartset) {
		String m;
		byte[] b = null;
		try {
			m = new String(msg.getBytes(), chartset);
			b = m.getBytes(chartset);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return b;
	}

	/**
	 * @param resource
	 *            原生字符串
	 * @param salt
	 *            盐
	 * @param iterations
	 *            散列次数
	 * @return
	 */
	public static String md5StringEncoder(String resource, String salt, int iterations) {

		Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		md5.setIterations(iterations);
		md5.encodePassword(resource, salt);

		return md5.encodePassword(resource, salt);
	}

	/**
	 * @param rawPass 原生密码串
	 * @param salt 盐
	 * @return
	 */
	public static String md5PasswordEncoder(String rawPass, String salt) {

		return md5StringEncoder(rawPass, salt, 3);
	}
	
	/**
	 * @param rawPass 原生密码串
	 * @return
	 */
	public static String md5PasswordEncoder(String rawPass) {

		return md5StringEncoder(rawPass, "", 3);
	}
}
