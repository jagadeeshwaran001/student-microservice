package com.nector.course.service;

import com.nector.course.entity.MarkScored;
import com.nector.course.exception.MarkNotFoundException;
import com.nector.course.repo.MarksScoredRepo;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkScoredService {

    private final MarksScoredRepo marksScoredRepo;

    public MarkScoredService(MarksScoredRepo marksScoredRepo) {
        this.marksScoredRepo = marksScoredRepo;
    }

    @Transactional
    public MarkScored saveMarkScored(final MarkScored markScored) {
        return marksScoredRepo.save(markScored);
    }

    public MarkScored getMarkScoredById(final long id) {
        return marksScoredRepo.findById(id).orElseThrow(() -> new MarkNotFoundException("MarkList Not found fot id:"+ id, HttpStatus.NOT_FOUND));
    }

    public List<MarkScored> getMarkScoredByStudentId(final long id) {
        return marksScoredRepo.findByStudentId(id);
    }
}
