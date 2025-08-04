package com.nector.course.repo;

import com.nector.course.entity.MarkScored;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarksScoredRepo extends JpaRepository<MarkScored, Long> {

//    @Query("SELECT m FROM MarkScored m WHERE m.studentName = ?1")
    List<MarkScored> findByStudentId(Long id);
}
