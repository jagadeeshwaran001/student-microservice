package com.nector.course.controller;

import com.nector.course.dto.MarkScoredResponse;
import com.nector.course.dto.ResponseDTO;
import com.nector.course.entity.MarkScored;
import com.nector.course.service.MarkScoredService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class MarkScoredContorller {

    private final MarkScoredService markScoredService;

    public MarkScoredContorller(MarkScoredService markScoredService) {
        this.markScoredService = markScoredService;
    }

    @PostMapping("/save-marks")
    public ResponseEntity<ResponseDTO<MarkScored>> saveStudentMarks(@RequestBody final MarkScored markScored) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO<MarkScored>(markScoredService.saveMarkScored(markScored)));
    }

    @GetMapping("/get-mark/{id}")
    public ResponseEntity<ResponseDTO<MarkScored>> getMarksById(@PathVariable("id") final long id) {
        return ResponseEntity.ok(new ResponseDTO<MarkScored>(markScoredService.getMarkScoredById(id)));
    }

    @GetMapping("/get-student-marklist/{id}")
    public ResponseEntity<ResponseDTO<List<MarkScored>>> getMarkListByStudent(@PathVariable("id") final long id) {
        return ResponseEntity.ok(new ResponseDTO<>(markScoredService.getMarkScoredByStudentId(id)));
    }
}
