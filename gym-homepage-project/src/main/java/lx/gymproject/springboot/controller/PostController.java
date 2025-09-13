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
import lx.gymproject.springboot.dao.GymPostDAO;
import lx.gymproject.springboot.vo.GymPostVO;

@Controller
public class PostController {
	
	@Autowired
	SqlSession session;
		
	@Autowired
	GymPostDAO dao;
	
		@RequestMapping("/postBoard.do")
		public String postBoard(HttpSession session, HttpServletRequest req) throws Exception {
			List<GymPostVO> list = dao.getDBList();
			req.setAttribute("data", list);
			
			System.out.println();
			return "postBoard";
		}
		
		@RequestMapping("/post.do")
		public String post(@RequestParam("poId") int poId, Model model) throws Exception {
			GymPostVO vo = dao.getDB(poId);
			model.addAttribute("data", vo);
			return "post";
		}		
		
		@RequestMapping("/postWritePage.do")
		public String postWritePage() throws Exception {
			System.out.print("글 작성 페이지");
			return "postWrite";
		}
		
		@RequestMapping("/postWrite.do")
		public String postWrite(GymPostVO vo) throws Exception {
			System.out.print(vo);
			dao.insertDB(vo);
			return "redirect:postBoard.do";
		}
		
		@RequestMapping("/postEditPage.do")
		public String postEdit(@RequestParam("poId") int poId, Model model) throws Exception {
			GymPostVO vo = dao.getDB(poId);
			model.addAttribute("po", vo);
			return "postEdit";
		}
		
		@RequestMapping("postEdit.do")
		public String postEdit(GymPostVO vo) throws Exception {
			System.out.print(" vo = "+ vo);
			dao.updateDB(vo);
			return "redirect:postBoard.do";
		}
		
		@RequestMapping("deleteDB.do") 
		public String deleteDB(@RequestParam("poId") int poId) throws Exception {
			dao.deleteDB(poId);
			return "redirect:postBoard.do";
		}

		}