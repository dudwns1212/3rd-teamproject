package lx.gymproject.springboot.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {

    /**
     * MultipartFile을 uploads 폴더에 저장하고 저장된 파일명을 반환
     * 기존 파일이 있다면 삭제 처리
     */
    public static String saveFile(MultipartFile file, String oldFileName) throws IOException {
        if (file == null || file.isEmpty()) return oldFileName; // 업로드 없으면 기존 파일 유지

        // 새 파일명 생성
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path path = Paths.get("uploads", fileName);
        Files.createDirectories(path.getParent());
        file.transferTo(path);

        // 기존 파일 삭제
        if (oldFileName != null && !oldFileName.isEmpty()) {
            Path oldPath = Paths.get("uploads", oldFileName);
            Files.deleteIfExists(oldPath);
        }

        return fileName;
    }
}