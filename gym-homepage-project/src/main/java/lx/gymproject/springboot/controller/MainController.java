package lx.gymproject.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/test.do")
	public String test() {
		return "test";
	}
	
	@RequestMapping("/test2.do")
	public String test2() {
		return "test2";
	}
	
	@RequestMapping("/home.do")
	public String home() {
		return "home";
	}
	
}
