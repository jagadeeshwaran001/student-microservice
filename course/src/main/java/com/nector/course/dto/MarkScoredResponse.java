package com.nector.course.dto;

import com.nector.course.entity.MarkScored;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class MarkScoredResponse {
    List<MarkScored> markScoredList = new ArrayList<>();
}
