package com.example.lab_intro_micro_student_catalog_service.feignclients;

import com.example.lab_intro_micro_student_catalog_service.dtos.StudentGradeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "lab-intro-micro-student-info-service")
public interface StudentFeignClient {

    @GetMapping("/api/student/{id}")
    StudentGradeDto getById(@PathVariable Long id);
}
