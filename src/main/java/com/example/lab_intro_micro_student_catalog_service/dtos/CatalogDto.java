package com.example.lab_intro_micro_student_catalog_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CatalogDto {
    private String courseName;
    private List<StudentGradeDto> studentGrades;
}
