package cargoes.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cargoes.annotation.Operation;

@Controller
public class HomeController {

	@Operation("主页")
	@GetMapping("/home")
	public String goHome(Model model) throws Exception {

		model.addAttribute("username", "管理员");

		return "home";
	}
}
