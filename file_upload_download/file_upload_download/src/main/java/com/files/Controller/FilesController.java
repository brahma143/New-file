package com.files.Controller;

import com.files.Entity.FileInfo;
import com.files.Service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

@RestController
@RequestMapping("/files")
public class FilesController {

    @Autowired
    private FileStorageService service;

    @PostMapping
    public ResponseEntity<FileInfo> uploadFiles(@RequestParam("file") MultipartFile file) throws IOException {

        FileInfo fileInfo = service.storeFile(file);

        return new ResponseEntity<>(fileInfo, HttpStatus.CREATED);
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> downloadFile(@RequestParam String fileName) throws MalformedURLException, FileNotFoundException {

        Resource resource = service.loadFileResource(fileName);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + resource.getFilename() + "\"").body(resource);

    }
}
