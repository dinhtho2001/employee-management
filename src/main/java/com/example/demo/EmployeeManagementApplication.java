package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.demo.config.FileStorageConfig;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageConfig.class
})
public class EmployeeManagementApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}

}
