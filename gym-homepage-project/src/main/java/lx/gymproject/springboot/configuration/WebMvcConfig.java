package lx.gymproject.springboot.configuration;

import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lx.gymproject.springboot.interceptor.CheckUserIdAndPostUserId;
import lx.gymproject.springboot.interceptor.LoginCheckInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(new LoginCheckInterceptor())
				.order(1)
				.addPathPatterns("/mypage.do", "/reservation.do",
				"/reservationDashboard.do", "/reservationInsert.do", "/updateMachine.do", "/machine_edit_form.do",
				"/insertMachine.do", "/deleteMachine.do", "/post.do", "/postWritePage.do", "/postEdit.do",
				"/postWrite.do");
	
		registry.addInterceptor(new CheckUserIdAndPostUserId())
				.order(2)
				.addPathPatterns("/postEditPage.do");
		
	}
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		String uploadPath = Paths.get("uploads").toAbsolutePath().toUri().toString();
		
		 registry.addResourceHandler("/uploads/**")
         .addResourceLocations(uploadPath);
    }
	
}