package com.files;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.files.Repository")
@EnableScheduling
public class FileUploadDownloadApplication {

	public static void main(String[] args) {

		SpringApplication.run(FileUploadDownloadApplication.class, args);
		System.out.println(" FileUploadDownloadApplication 9091 !! ");
		
	}

}
