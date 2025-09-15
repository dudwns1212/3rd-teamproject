package lx.gymproject.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
	
	@GetMapping("/home.do")
	public String home() {
		return "home";
	}
	
	//지도
	@GetMapping("/location.do")
	public String location() {
		return "location";
	}
	
}
