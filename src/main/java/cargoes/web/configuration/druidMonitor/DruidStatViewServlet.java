package cargoes.web.configuration.druidMonitor;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.alibaba.druid.support.http.StatViewServlet;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/druid/*", initParams = { //
		@WebInitParam(name = "allow", value = "127.0.0.1"), // IP白名单
		@WebInitParam(name = "deny", value = "192.168.11.11"), // IP黑名单
		@WebInitParam(name = "loginUsername", value = "druid"), // 用户名
		@WebInitParam(name = "loginPassword", value = "druid"), // 密码
		@WebInitParam(name = "resetEnable", value = "false")// 禁用HTML页面上的“ResetAll”功能
})
public class DruidStatViewServlet extends StatViewServlet {
}