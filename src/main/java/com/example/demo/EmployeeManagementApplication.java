package com.example.demo;

import org.flywaydb.core.Flyway;
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
//		Flyway flyway = Flyway.configure()
//				.dataSource("jdbc:mysql://localhost:3306/employee_management","root","mysql123456")
//				.load();
//		flyway.migrate();
	}

}
