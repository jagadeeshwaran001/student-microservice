package com.nector.student.service;

import com.nector.student.entity.Student;
import com.nector.student.exception.StudentNotFoundException;
import com.nector.student.repo.StudentRepo;
import com.nector.student.restInvoker.CourseClient;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepo studentRepo;
    private final CourseClient courseClient;

    public StudentService(StudentRepo studentRepo, CourseClient courseClient) {
        this.studentRepo = studentRepo;
        this.courseClient = courseClient;
    }

    @Transactional
    public Student saveStudent(final Student course) {
        return studentRepo.save(course);
    }

    public Student getstudent(final long id) {
        return  studentRepo.findById(id).orElseThrow(() -> new StudentNotFoundException("Course Not found course Id:"+ id, HttpStatus.NOT_FOUND));
    }

    public List<Object> getMarkListForStudent(long id) {
        return courseClient.getMarkList(id);
    }
}
