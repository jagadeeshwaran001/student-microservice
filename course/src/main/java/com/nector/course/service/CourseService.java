package com.nector.course.service;

import com.nector.course.entity.Course;
import com.nector.course.exception.CourseNotFoundException;
import com.nector.course.repo.CourseRepo;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private final CourseRepo courseRepo;

    public CourseService(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Transactional
    public Course saveCourse(final Course course) {
        return courseRepo.save(course);
    }

    public Course getCourseById(final long id) {
        return  courseRepo.findById(id).orElseThrow(() -> new CourseNotFoundException("Course Not found course Id:"+ id, HttpStatus.NOT_FOUND));
    }
}
