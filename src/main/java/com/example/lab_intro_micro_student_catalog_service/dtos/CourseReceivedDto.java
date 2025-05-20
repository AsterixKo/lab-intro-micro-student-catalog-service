package com.example.lab_intro_micro_student_catalog_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseReceivedDto {

    private String code;
    private String name;
}
