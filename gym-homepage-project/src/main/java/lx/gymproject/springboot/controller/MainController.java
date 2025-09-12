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


	// 트레이너 소개 페이지 추가
	@RequestMapping("explainTrainer.do")
	public String explainTrainer() {
		return "explainTrainer";
	}
	
	// 시설 안내 페이지 추가
	@RequestMapping("facility.do")
	public String facility() {
		return "facility";
	}
	//지도
	@RequestMapping("location.do")
	public String location() {
		return "location";
	}
	
}
