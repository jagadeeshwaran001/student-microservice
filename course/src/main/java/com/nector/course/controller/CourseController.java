package com.nector.course.controller;

import com.nector.course.dto.ResponseDTO;
import com.nector.course.entity.Course;
import com.nector.course.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/save-course")
    public ResponseEntity<ResponseDTO<Course>> saveCourse(@RequestBody final Course course) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO<>(courseService.saveCourse(course)));
    }

    @GetMapping("/get-course/{id}")
    public ResponseEntity<ResponseDTO<Course>> getResponseById(@PathVariable("id") final long id) {
        return ResponseEntity.ok(new ResponseDTO<>(courseService.getCourseById(id)));
    }
}
