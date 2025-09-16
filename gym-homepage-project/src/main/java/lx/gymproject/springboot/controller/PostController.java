package lx.gymproject.springboot.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lx.gymproject.springboot.dao.GymPostDAO;
import lx.gymproject.springboot.util.FileUploadUtil;
import lx.gymproject.springboot.vo.GymPostVO;
import lx.gymproject.springboot.vo.GymUserVO;

@Controller
public class PostController {

	@Autowired
	SqlSession session;

	@Autowired
	GymPostDAO dao;
	
		@GetMapping("/postBoard.do")
		public String postBoard(Model model, @RequestParam(defaultValue = "1") int page) throws Exception {
			
            int pageSize = 10;
            int offset = (page - 1) * pageSize;
            
            Map<String, Object> params = new HashMap<>();
            params.put("limit", pageSize);
            params.put("offset", offset);
            List<GymPostVO> pageList = dao.getDBListPaging(params);
            
            int totalpost = dao.getDBCount();
            int totalPages = (int) Math.ceil((double) totalpost / pageSize);

            model.addAttribute("data", pageList);
            model.addAttribute("currentPage", page);
            model.addAttribute("totalPages", totalPages);
			return "post/postBoard";
		}

		@GetMapping("/post.do")
		public String post(@RequestParam("poId") int poId, Model model) throws Exception {
			dao.increaseView(poId);
			GymPostVO vo = dao.getDB(poId);
			model.addAttribute("data", vo);
			return "post/post";
		}

		@GetMapping("/postWritePage.do")
		public String postWritePage() throws Exception {
			return "post/postWrite";
		}
		
		@PostMapping("/postWrite.do")
		public String postWrite(GymPostVO vo, HttpSession session) throws Exception {
			GymUserVO loginUser = (GymUserVO) session.getAttribute("loginUser");
		    vo.setPoUserId(loginUser.getUserId());
		    
		    String savedFileName = FileUploadUtil.saveFile(vo.getFile(), null); // 새 글이니까 기존 파일 없음
		    vo.setPoImg(savedFileName);
		    
		    dao.insertDB(vo);
		    return "redirect:/postBoard.do";
		}

	@GetMapping("/postEditPage.do")
	public String postEdit(@RequestParam("poId") int poId, Model model) throws Exception {
		GymPostVO vo = dao.getDB(poId);
		model.addAttribute("po", vo);
		return "post/postEdit";
	}

	@PostMapping("postEdit.do")
	public String postEdit(GymPostVO vo, HttpSession session) throws Exception {

		GymPostVO existingFile = dao.getDB(vo.getPoId());

		String savedFileName = FileUploadUtil.saveFile(vo.getFile(), existingFile.getPoImg());
		vo.setPoImg(savedFileName);

		dao.updateDB(vo);
		return "redirect:postBoard.do";
	}

	@GetMapping("deleteDB.do")
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