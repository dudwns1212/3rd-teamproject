package lx.gymproject.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import lx.gymproject.springboot.dao.GymPostCommentDAO;
import lx.gymproject.springboot.vo.GymUserVO;
import lx.gymproject.springboot.vo.GymPostCommentVO;

@RestController
public class PostCommentController {
	
	@Autowired
    GymPostCommentDAO dao;
	
    @GetMapping("/list")
    public List<GymPostCommentVO> listComment(@RequestParam int poId) {
    	return dao.getCommentsByPostId(poId);
    }
    
    @PostMapping("/write")
    public String write(@RequestBody GymPostCommentVO vo, HttpSession session) {
        GymUserVO loginUser = (GymUserVO) session.getAttribute("loginUser");
        vo.setUserId(loginUser.getUserId());
        vo.setAuthorName(loginUser.getUserName());
        dao.insertComment(vo);
        return "success";
    }
    
    @PostMapping("/deletePostComment")
    public String deletePostComment(@RequestParam(value="cmId") int cmId) {
    	dao.deletePostCommentByCmId(cmId);
    	return "success";
    }
	
}
