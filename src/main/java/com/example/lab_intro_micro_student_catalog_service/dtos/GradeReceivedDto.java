package com.example.lab_intro_micro_student_catalog_service.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GradeReceivedDto {
    private Long id;
    private double grade;
    private CourseReceivedDto course;
    private Long studentId;
}
