package lx.gymproject.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import lx.gymproject.springboot.dao.GymMachineDAO;
import lx.gymproject.springboot.vo.GymMachineVO;

@Controller
public class MainController {

	@Autowired
	GymMachineDAO dao;
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/home.do";
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