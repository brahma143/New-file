package com.files.Service;

import com.files.Entity.FileInfo;
import com.files.Repository.FileInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;

@Service
public class FileStorageService {

    @Autowired
    private FileInfoRepository repo;

    @Value("${file.upload-dir}")
    private String uploadDir;

    public FileInfo storeFile(MultipartFile file) throws IOException {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }

        Path filePath = uploadPath.resolve(fileName);
        Files.copy(file.getInputStream(),filePath, StandardCopyOption.REPLACE_EXISTING);

        FileInfo fileInfo = new FileInfo();

        fileInfo.setFileName(fileName);
        fileInfo.setFileType(file.getContentType());
        fileInfo.setFilePath(filePath.toString());
        fileInfo.setSize(file.getSize());
        fileInfo.setUploadDate(LocalDateTime.now());
       return repo.save(fileInfo);
        //return fileInfo;
    }

    public Resource loadFileResource(String fileName) throws FileNotFoundException, MalformedURLException {

        FileInfo file = repo.findByFileName(fileName)
                .orElseThrow(() -> new FileNotFoundException("File not found"));
        //(Files.exists(Paths.get(fileName)){}

        Path filePath = Paths.get(file.getFilePath());
        return new UrlResource(filePath.toUri());
    }

}
