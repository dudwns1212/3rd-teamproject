package lx.gymproject.springboot.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


//AuthInterceptor 는 request 요청이  
//앞에 /auth/** 로 요청한 주소에서만 동작 하도록 설계 할 예정
@Component // IoC 처리 확인 
public class LoginCheckInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {
		// 사용자 요청 주소 확인
		String uri = req.getRequestURI();
		System.out.println("요청 주소 : " + uri);
		
		// 세션 여부 확인 
		HttpSession session = req.getSession();
		
		if(session.getAttribute("loginUser") == null) {
			System.out.println("인증 안된 사용자");
			res.sendRedirect("/loginPage.do?rediretURI=" + uri + "&block=true");
			return false; 
		}
		
		return true;
	}
	
}
