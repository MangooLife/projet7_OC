package com.thamarai.mloanmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MloanmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MloanmanagementApplication.class, args);
	}

}
