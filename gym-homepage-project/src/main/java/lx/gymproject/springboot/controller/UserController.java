package lx.gymproject.springboot.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
	public String login(Model model, HttpSession session,
			@RequestParam(value="userEmail") String userEmail,
			@RequestParam(value="userPassword") String userPassword) {
		
		GymUserVO vo = dao.doLoginById(userEmail);
		
		// 사용자가 존재하지 않거나 비밀번호가 틀린 경우
		if(vo == null || !vo.getUserPassword().equals(userPassword)) {
			model.addAttribute("loginFailed", true);
			return "loginPage";
		}
		
		// 로그인 성공 - 세션에 사용자 정보 저장
		session.setAttribute("loginUser", vo);
		return "home";
	}
	
	@RequestMapping("register.do")
	public String register(GymUserVO vo, Model model) {
		int checkpw = 0;
		try {
			checkpw = dao.doRegisterByUserVO(vo);
		}catch(Exception e) {
				
		}
		
		if(checkpw > 0) {
			model.addAttribute("registerSuccess", checkpw);
		} else{
			model.addAttribute("registerFailed", checkpw+1);
		}
		System.out.println(checkpw);
		return "registerPage";
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.invalidate(); // 세션 무효화
		return "redirect:loginPage.do";
	}
	
	@RequestMapping("mypage.do")
	public String mypage(HttpSession session, Model model) {
		GymUserVO loginUser = (GymUserVO) session.getAttribute("loginUser");
		if(loginUser == null) {
			return "redirect:loginPage.do";
		}
		model.addAttribute("user", loginUser);
		return "mypage";
	}
	
	
	@RequestMapping("reservation.do")
	public String reservation() {
		return "reservation";
	}

	@RequestMapping("reservationDashboard.do")
	public String reservationDashboard() {
		return "dashboard";
	}
	
	@RequestMapping("appointmentHome.do")
	public String appointmentHome() {
		return "appointmentHome";
	}
}
