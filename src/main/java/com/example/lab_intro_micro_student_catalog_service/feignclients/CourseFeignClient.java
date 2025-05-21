package com.example.lab_intro_micro_student_catalog_service.feignclients;

import com.example.lab_intro_micro_student_catalog_service.dtos.CourseReceivedDto;
import com.example.lab_intro_micro_student_catalog_service.dtos.GradeReceivedDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "lab-intro-micro-grades-data-service")
public interface CourseFeignClient {
    @GetMapping("/api/course/by-code")
    CourseReceivedDto getCourseByCode(@RequestParam(name = "code") String code);

    @GetMapping("/api/course/grades-by-course-code")
    List<GradeReceivedDto> getGradesByCourseCode(@RequestParam(name = "code") String code);

}
