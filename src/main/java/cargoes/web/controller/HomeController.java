package cargoes.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cargoes.annotation.Operation;
import cargoes.web.mvc.MvcConfiguration;
import cargoes.web.security.CustomWebAuthenticationDetails;

@Controller
public class HomeController {

	@SuppressWarnings("unused")
	@GetMapping(MvcConfiguration.LOGIN_PAGE_URL)
	public String goToLoginPage(HttpSession session) throws Exception {
		
		Integer failureCount = (Integer) session.getAttribute(MvcConfiguration.AUTHENTICATION_FAILURE_COUNT);
		
		if (MvcConfiguration.AUTHENTICATION_VERIFYCODE_ENABLED 
				&& CustomWebAuthenticationDetails.checkFailuerCountMoreThanAllowedValue(failureCount)) {
			
			session.setAttribute(MvcConfiguration.AUTHENTICATION_SHOW_VERIFYCODE_IMAGE_KEY, true);
		} else {
			
			session.setAttribute(MvcConfiguration.AUTHENTICATION_SHOW_VERIFYCODE_IMAGE_KEY, false);
		}

		return MvcConfiguration.LOGIN_PAGE_NAME;
	}
	
	@GetMapping(value="/changeLanauage", params={"lang"})
    public String changeLanauage(HttpServletRequest request,HttpServletResponse response,String lang){

       return "redirect:/home";

    }

	@Operation("主页")
	@GetMapping("/home")
	public String goHome(Model model) throws Exception {
		
		String username = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}

		model.addAttribute("username", username);

		return "home";
	}
}
