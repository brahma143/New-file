package com.files.Configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Component
@ConfigurationProperties(prefix = "files")
public class FileStorageProperties {

    private String uploadDir;

    public String getUploadDir() {
        return uploadDir;
    }


    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
    
    @Bean
    public CommonsMultipartResolver multipartResolver() {
    	
    	CommonsMultipartResolver resolver = new CommonsMultipartResolver();
    	resolver.setMaxUploadSize(10 * 1024 * 1024);
    	resolver.setMaxUploadSizePerFile(10 * 1024 * 1024);
    	return resolver;
}
}