package com.example.lab_intro_micro_student_catalog_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LabIntroMicroStudentCatalogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabIntroMicroStudentCatalogServiceApplication.class, args);
	}

}
