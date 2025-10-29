package com.overdaily.Overdaily;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class OverdailyApplication {
	public static void main(String[] args) {
		SpringApplication.run(OverdailyApplication.class, args);
	}


}
