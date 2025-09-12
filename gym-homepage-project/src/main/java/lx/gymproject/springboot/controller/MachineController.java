package lx.gymproject.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lx.gymproject.springboot.dao.GymMachineDAO;
import lx.gymproject.springboot.vo.GymMachineVO;

@Controller
public class MachineController {

   
	@Autowired
	GymMachineDAO dao;

	/*
	 * @RequestMapping("/explainMachine.do") public String getMachine(Model model)
	 * throws Exception { GymMachineVO vo =dao.getMachine();
	 * model.addAttribute("vo", vo); System.out.println(vo); return
	 * "explainMachine"; }
	 */ 
	
	@RequestMapping("/explainMachine.do")
	public String machineList(HttpServletRequest req, Model model) {
		List <GymMachineVO> list= dao.getMachineList();
		model.addAttribute("data", list);
		return "explainMachine";
	}
	
	@RequestMapping("/updateMachine.do")
	public String updateMachine(GymMachineVO vo) throws Exception {
		System.out.println("vo = " +vo);
		try {
			dao.updateMachine(vo);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		System.out.println(vo.machinePrice); 
		return "redirect:explainMachine.do";
	}
	
	
	/*
	 * @RequestMapping("/machine_edit_form.do") public String
	 * edit(HttpServletRequest req) throws Exception{
	 * System.out.println(req.getParameter("machineId")); int machineId =
	 * Integer.parseInt(req.getParameter("machineId"));
	 * 
	 * GymMachineVO vo = dao.getMachine(machineId);
	 * 
	 * req.setAttribute("vo", vo); return "machine_edit_form"; }
	 */
	
	
	
	@RequestMapping("/machine_edit_form.do")
	public String edit(@RequestParam("machineId") int machineId, Model model) throws Exception {
		GymMachineVO vo = dao.getMachine(machineId);
		model.addAttribute("vo", vo);
		return "machine_form";
	}
	
	
	@RequestMapping("/insertMachine.do")
	public String insertMachine(GymMachineVO vo) throws Exception {
		System.out.println(vo);
		dao.insertMachine(vo);
		return "redirect:explainMachine.do";
	}
	
	
	
}
