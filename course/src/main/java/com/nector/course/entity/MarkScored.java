package com.nector.course.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarkScored {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long courseId;

    private long studentId;

    private double markScored;

    @UpdateTimestamp
    private LocalDateTime updateTs;

    @CreationTimestamp
    private LocalDateTime createTs;
}
