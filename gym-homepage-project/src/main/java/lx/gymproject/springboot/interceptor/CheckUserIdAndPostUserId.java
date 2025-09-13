package lx.gymproject.springboot.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lx.gymproject.springboot.vo.GymUserVO;

@Component
public class CheckUserIdAndPostUserId implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {
		System.out.println("게시물 작성자인지 확인합니다");
		
		HttpSession session = req.getSession();
		String authorName = req.getParameter("authorName");
		
        GymUserVO loginUser = (GymUserVO) session.getAttribute("loginUser");
		
		if(!loginUser.getUserName().equals(authorName)) {
			System.out.println("작성자가 아닙니다");
			res.sendRedirect("/postBoard.do?block=true");
			return false;
		}
		
		return true;
	}
}
