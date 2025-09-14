package lx.gymproject.springboot.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lx.gymproject.springboot.dao.GymPostDAO;
import lx.gymproject.springboot.vo.GymPostVO;
import lx.gymproject.springboot.vo.GymUserVO;

@Controller
public class PostController {
	
	@Autowired
	SqlSession session;
		
	@Autowired
	GymPostDAO dao;
	
		@RequestMapping("/postBoard.do")
		public String postBoard(HttpSession session, HttpServletRequest req) throws Exception {
			List<GymPostVO> list = dao.getDBList();
			Collections.reverse(list);
			req.setAttribute("data", list);
			System.out.println();
			return "postBoard";
		}
		
		@RequestMapping("/post.do")
		public String post(@RequestParam("poId") int poId, Model model) throws Exception {
			dao.increaseView(poId);
			GymPostVO vo = dao.getDB(poId);
			model.addAttribute("data", vo);
			return "post";
		}		
		
		@RequestMapping("/postWritePage.do")
		public String postWritePage() throws Exception {
			return "postWrite";
		}
		
		@RequestMapping("/postWrite.do")
		public String postWrite(GymPostVO vo, HttpSession session) throws Exception {
			if (vo.getPoUserId() == 0) {
		        GymUserVO loginUser = (GymUserVO) session.getAttribute("loginUser");
		        if (loginUser != null) {
		            vo.setPoUserId(loginUser.getUserId());
		        }
			}
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
			dao.updateDB(vo);
			return "redirect:postBoard.do";
		}
		
		@RequestMapping("deleteDB.do") 
		public String deleteDB(@RequestParam("poId") int poId) throws Exception {
			System.out.println(poId);
			dao.deleteDB(poId);
			return "redirect:postBoard.do";
		}

	    @PostMapping("/post/like")
	    @ResponseBody
	    public Map<String, Object> updateLike(@RequestParam("poId") int poId) throws Exception {
	        dao.increaseLike(poId); 
	        int newLikeCount = dao.getLikeCount(poId); 
	        Map<String, Object> response = new HashMap<>();
	        response.put("newCount", newLikeCount);
	        return response;    
	    }
	    
	    @PostMapping("/post/dislike")
	    @ResponseBody
	    public Map<String, Object> updateDisLike(@RequestParam("poId") int poId) throws Exception {
	        dao.increaseDisLike(poId); 
	        int newDisLikeCount = dao.getDisLikeCount(poId); 
	        Map<String, Object> response = new HashMap<>();
	        response.put("newCount", newDisLikeCount);
	        return response;
	    }		
		
}