package lx.gymproject.springboot.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@Autowired
	SqlSession session;
	
	@RequestMapping("loginPage.do")
	public String loginPage() {
		return "loginPage";
	}
	
	@RequestMapping("registerPage.do")
	public String registerPage() {
		return "registerPage";
	}
	
	@RequestMapping("reservation.do")
	public String reservation() {
		return "reservation";
	}
	
	
}
