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
	
	@RequestMapping("/home.do")
	public String home() {
		return "home";
	}
	
	@RequestMapping("explainMachine.do")
	public String machineList(HttpServletRequest req, Model model) {
		List<GymMachineVO> list = dao.getMachineList();
		model.addAttribute("vo", list);
		return "explainMachine";
	}
	
	
	
}
