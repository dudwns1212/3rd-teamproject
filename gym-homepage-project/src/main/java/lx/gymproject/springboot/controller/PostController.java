package lx.gymproject.springboot.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
		@RequestMapping("postBoard.do")
		public String postBoard(HttpSession session, HttpServletRequest req) throws Exception {
			List<GymPostVO> list = dao.getDBList();
			req.setAttribute("data", list);
			return "postBoard";
		}
		
		@RequestMapping("post.do")
		public String post(HttpSession session, HttpServletRequest req) throws Exception {
			List<GymPostVO> list = dao.getDBList();
			req.setAttribute("data", list);
			return "post";
		}		
		
		@RequestMapping("/insert.do")
		public String insert(GymPostVO vo) throws Exception {
			System.out.print(vo);
			dao.insertDB(vo);
			return "redirect:addrbook_list.do";
		}
		
		@RequestMapping("/addrbook_form.do")
		public String form() {
			return "addrbook_form";
		}

		@RequestMapping("addrbook_list.do")
		public String list(HttpSession session, HttpServletRequest req) throws Exception {
			List<GymPostVO> list = dao.getDBList();
			req.setAttribute("data", list);
			return "addrbook_list";
		}
		
		@RequestMapping("edit.do")
		public String getDB(@RequestParam("abId") int abId, HttpServletRequest req) throws Exception {
			GymPostVO vo = dao.getDB(abId);
			req.setAttribute("ab", vo);
			return "addrbook_edit_form";
		}
		
		@RequestMapping("update.do")
		public String updateDB(GymPostVO vo) throws Exception {
			System.out.print("vo = "+ vo);
			dao.updateDB(vo);
			return "redirect:addrbook_list.do";
		}
		


	
}
