package lx.gymproject.springboot.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// DataAccessException 또는 그 하위 예외가 어디서든 발ㄹ생하면 이 메소드가 실행됨
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(DataAccessException.class)
	public String handelDataAccessException(DataAccessException e, RedirectAttributes redirectAttributes) {
		System.err.println("전역 예외처리기 (DB) : " + e.getMessage());
		
		// 여러 페이지로 보낼 메시지
		// model.addAttribute("errorMessage", "DB처리중 문제가 발생했습니다. 관리자에게 문의바랍니다.");
		// redirectAttributes는 redirect시 데이터를 한번만 전달하고 사라짐 즉, 유지되지 않는 데이터라는 뜻임 1회용
		redirectAttributes.addFlashAttribute("errorMessage", "DB 처리 중 문제가 발생했습니다. 관리자에게 문의바랍니다.");
		return "redirect:/postBoard.do";
	}
	
	// 오류먹는 하마
	@ExceptionHandler(Exception.class)
	public String handleExcption(Exception e, RedirectAttributes redirectAttributes) {
		System.err.print("전역 예외 처리기 (일반) : " + e.getMessage());
		
		//model.addAttribute("errorMessage", "알 수 없는 오류가 발생했습니다.");
		redirectAttributes.addFlashAttribute("errorMessage", "알 수 없는 오류가 발생했습니다. 관리자에게 문의바랍니다.");
		return "redirect:/postBoard.do";
	}
	
}
