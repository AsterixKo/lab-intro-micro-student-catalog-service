package com.example.lab_intro_micro_student_catalog_service.services;

import com.example.lab_intro_micro_student_catalog_service.dtos.CatalogDto;
import com.example.lab_intro_micro_student_catalog_service.dtos.CourseReceivedDto;
import com.example.lab_intro_micro_student_catalog_service.dtos.GradeReceivedDto;
import com.example.lab_intro_micro_student_catalog_service.dtos.StudentGradeDto;
import com.example.lab_intro_micro_student_catalog_service.feignclients.CourseFeignClient;
import com.example.lab_intro_micro_student_catalog_service.feignclients.StudentFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class CatalogService {

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    CourseFeignClient courseFeignClient;

    @Autowired
    StudentFeignClient studentFeignClient;

    public ResponseEntity<?> findStudentsCatalogPerCourse(String code) {
        try {
            log.info("entrando en findStudentsCatalogPerCourse");
            CatalogDto catalogDto = new CatalogDto();

            //obtener el nombre del couse por code localhost:8081/api/course/by-code?code=mat
            CourseReceivedDto course = courseFeignClient.getCourseByCode(code);

            catalogDto.setCourseName(course.getName());

            log.info("obtenemos CourseReceivedDto {}", course);
            //obtenemos todos los grades
//            ResponseEntity<GradeReceivedDto[]> response = restTemplate.getForEntity(
//                    "http://lab-intro-micro-grades-data-service/api/course/grades-by-course-code?code=" + code,
//                    GradeReceivedDto[].class);
            log.info("haciendo peticion courseFeignClient.getGradesByCourseCode");
            List<GradeReceivedDto> gradeReceivedDtos = courseFeignClient.getGradesByCourseCode(code);

            log.info("gradeReceivedDtos {}", gradeReceivedDtos);
            List<StudentGradeDto> studentGrades = new ArrayList<>();
            for (GradeReceivedDto grade : gradeReceivedDtos) {
                StudentGradeDto studentGradeDto = new StudentGradeDto();
                studentGradeDto.setGrade(grade.getGrade());
                //pedirlo a la api
//                StudentGradeDto student = restTemplate.getForObject(
//                        "http://lab-intro-micro-student-info-service/api/student/" + grade.getStudentId(),
//                        StudentGradeDto.class);
                log.info("haciendo peticion del estudiante studentFeignClient.getById");
                StudentGradeDto student = studentFeignClient.getById(grade.getStudentId());
                studentGradeDto.setAge(student.getAge());
                studentGradeDto.setName(student.getName());

                studentGrades.add(studentGradeDto);
            }
            catalogDto.setStudentGrades(studentGrades);
//            return new ResponseEntity<>(gradeReceivedDtos, HttpStatus.OK);
            return new ResponseEntity<>(catalogDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
//    public ResponseEntity<?> findStudentsCatalogPerCourse(String code) {
//        try {
//            CatalogDto catalogDto = new CatalogDto();
//
//            //obtener el nombre del couse por code localhost:8081/api/course/by-code?code=mat
//            CourseReceivedDto course = restTemplate.getForObject(
//                    "http://lab-intro-micro-grades-data-service/api/course/by-code?code=" + code,
//                    CourseReceivedDto.class);
//            catalogDto.setCourseName(course.getName());
//
//            //obtenemos todos los grades
//            ResponseEntity<GradeReceivedDto[]> response = restTemplate.getForEntity(
//                    "http://lab-intro-micro-grades-data-service/api/course/grades-by-course-code?code=" + code,
//                    GradeReceivedDto[].class);
//            GradeReceivedDto[] gradeReceivedDtos = response.getBody();
//
//            List<StudentGradeDto> studentGrades = new ArrayList<>();
//            for (GradeReceivedDto grade : gradeReceivedDtos) {
//                StudentGradeDto studentGradeDto = new StudentGradeDto();
//                studentGradeDto.setGrade(grade.getGrade());
//                //pedirlo a la api
//                StudentGradeDto student = restTemplate.getForObject(
//                        "http://lab-intro-micro-student-info-service/api/student/" + grade.getStudentId(),
//                        StudentGradeDto.class);
//                studentGradeDto.setAge(student.getAge());
//                studentGradeDto.setName(student.getName());
//
//                studentGrades.add(studentGradeDto);
//            }
//            catalogDto.setStudentGrades(studentGrades);
////            return new ResponseEntity<>(gradeReceivedDtos, HttpStatus.OK);
//            return new ResponseEntity<>(catalogDto, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }

}
