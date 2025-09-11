package lx.gymproject.springboot.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import lx.gymproject.springboot.dao.GymUserDAO;
import lx.gymproject.springboot.vo.GymUserVO;

@Controller
public class UserController {
	
	@Autowired
	SqlSession session;
	
	@Autowired
	GymUserDAO dao;
	
	@RequestMapping("loginPage.do")
	public String loginPage() {
		return "loginPage";
	}
	
	@RequestMapping("registerPage.do")
	public String registerPage() {
		return "registerPage";
	}
	
	@PostMapping("login.do")
	public String login(HttpServletRequest req, @RequestParam(value="userEmail")String userEmail) {
		GymUserVO vo = dao.doLoginById(userEmail);
		req.setAttribute("user", vo);
		return "home";
	}
	
	@PostMapping("register.do")
	public String register(GymUserVO vo) {
		dao.doRegisterByUserVO(vo);
		return "registerPage";
		
	}
	
	
}
