package lx.gymproject.springboot.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Controller
public class UploadController {

    @Value("${file.upload-dir}")
    private String uploadDir;
    
    @RequestMapping("uploadForm.do")
    public String uploadForm() {
    	return "uploadForm";
    }
    
    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, Model model) throws IOException {
        if (file.isEmpty()) {
            model.addAttribute("message", "파일을 선택하세요!");
            return "uploadForm";
        }

        // 파일 이름 중복 방지
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path path = Paths.get(uploadDir, fileName);

        // 폴더가 없으면 생성
        Files.createDirectories(path.getParent());

        // 파일 저장
        file.transferTo(path);     
 
        // 업로드 후 보여줄 이미지 경로 model에 담기
        model.addAttribute("imageUrl", "/images/" + fileName);

        return "uploadResult";
    }
}
