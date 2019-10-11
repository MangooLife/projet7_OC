package com.thamarai.mbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(MbookApplication.class, args);
	}

}
