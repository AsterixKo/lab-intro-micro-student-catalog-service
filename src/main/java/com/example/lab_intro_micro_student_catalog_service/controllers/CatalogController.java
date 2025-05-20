package com.example.lab_intro_micro_student_catalog_service.controllers;

import com.example.lab_intro_micro_student_catalog_service.services.CatalogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @GetMapping("/")
    public ResponseEntity<?> studentsCatalogPerCourse(@RequestParam(name = "code") String code){
        return catalogService.findStudentsCatalogPerCourse(code);
    }
}
