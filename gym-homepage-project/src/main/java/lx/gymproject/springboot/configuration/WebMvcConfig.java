package lx.gymproject.springboot.configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
				"/postWrite.do","/write");
	
		registry.addInterceptor(new CheckUserIdAndPostUserId())
				.order(2)
				.addPathPatterns("/postEditPage.do");
		
	}
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // uploads 폴더 절대 경로
        Path uploadPath = Paths.get("uploads").toAbsolutePath();
        String resourceLocation = "file:" + uploadPath.toString().replace("\\", "/") + "/";

        
        // 리소스 핸들러 등록
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations(resourceLocation);
    }
	
}