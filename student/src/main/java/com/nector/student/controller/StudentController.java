package com.nector.student.controller;

import com.nector.student.dto.ResponseDTO;
import com.nector.student.entity.Student;
import com.nector.student.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/save-student")
    public ResponseEntity<ResponseDTO<Student>> saveCourse(@RequestBody final Student student) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO<>(studentService.saveStudent(student)));
    }

    @GetMapping("/get-student/{id}")
    public ResponseEntity<ResponseDTO<Student>> getResponseById(@PathVariable("id") final long id) {
        return ResponseEntity.ok(new ResponseDTO<>(studentService.getstudent(id)));
    }

    @GetMapping("/get-student-mark-list/{id}")
    public ResponseEntity<ResponseDTO<List<Object>>> getMarkList(@PathVariable("id") final long id) {
        return ResponseEntity.ok(new ResponseDTO<List<Object>>(studentService.getMarkListForStudent(id)));
    }

}
