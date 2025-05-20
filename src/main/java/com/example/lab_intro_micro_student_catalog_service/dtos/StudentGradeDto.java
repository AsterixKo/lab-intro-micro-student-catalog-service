package com.example.lab_intro_micro_student_catalog_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentGradeDto {

    private String name;
    private int age;
    private double grade;
}
