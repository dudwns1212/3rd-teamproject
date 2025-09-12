package lx.gymproject.springboot.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lx.gymproject.springboot.dao.GymMachineDAO;
import lx.gymproject.springboot.dao.GymPostDAO;
import lx.gymproject.springboot.vo.GymMachineVO;
import lx.gymproject.springboot.vo.GymPostVO;

@Controller
public class explainMachineController {
	
	@Autowired

	GymMachineDAO dao;


@RequestMapping("/explainMachine.do")

	public String machineList(HttpServletRequest req, Model model) {

		List <GymMachineVO> list= dao.getMachineList();
		model.addAttribute("vo", list);
		return "explainMachine";

	}
		


	
}
