package lx.gymproject.springboot.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lx.gymproject.springboot.dao.GymMachineDAO;
import lx.gymproject.springboot.util.FileUploadUtil;
import lx.gymproject.springboot.vo.GymMachineVO;

@Controller
public class MachineController {

	@Autowired
	GymMachineDAO dao;

	@GetMapping("/explainMachine.do")
	public String machineList(Model model) {
		List<GymMachineVO> list = dao.getMachineList();
		model.addAttribute("data", list);
		return "machine/explainMachine";
	}

	@PostMapping("/updateMachine.do")

	public String updateMachine(GymMachineVO vo) throws Exception {

		GymMachineVO existingFile = dao.getMachine(vo.machineId);

		try {
			String fileName = FileUploadUtil.saveFile(vo.getFile(), existingFile.getMachineImg());
			vo.setMachineImg(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}

		dao.updateMachine(vo);
		return "redirect:explainMachine.do";
	}

	@GetMapping("/machine_edit_form.do")
	public String edit(@RequestParam("machineId") int machineId, Model model) throws Exception {
		GymMachineVO vo = dao.getMachine(machineId);
		model.addAttribute("vo", vo);
		return "machine/machine_edit_form";
	}

	@PostMapping("/insertMachine.do")
	public String insertMachine(GymMachineVO vo) throws Exception {

		try {
			String fileName = FileUploadUtil.saveFile(vo.getFile(), null);
			vo.setMachineImg(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}

		dao.insertMachine(vo);
		return "redirect:explainMachine.do";
	}

	@PostMapping("/deleteMachine.do")
	public String deleteMachine(@RequestParam(value = "machineId") int machineId) throws Exception {
		System.out.println("deleteMachine 실행됨" + machineId);
		dao.deleteMachine(machineId);
		return "redirect:explainMachine.do";
	}

	// 추가화면으로(marchine_form)
	@GetMapping("/machine_form.do")
	public String goToMarchineForm() {
		return "machine/machine_form";
	}

	@GetMapping("/cancle.do")
	public String goToExpainMachine() {
		return "redirect:explainMachine.do";
	}

}
