package com.files.SchedulaR;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class ISSURID_Schedular {
	//cron = "* 0/5 * * * ?",
	private static final Logger logger = LoggerFactory.getLogger(ISSURID_Schedular.class);
	@Scheduled(cron = "* 5 * * * *", zone = "Asia/Kolkata")
	public void runEveryTenMinutes() {
	    System.out.println("Running job at " + LocalDateTime.now());
	}
	
//	@Scheduled(cron = "0/10 * * * * ?", zone = "Asia/kolkata")
//	public void runEveryTenMintues() {
//		System.out.println("Running job at "+LocalDateTime.now());
//	}
}
