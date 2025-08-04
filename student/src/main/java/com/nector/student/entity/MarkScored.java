package com.nector.student.entity;

import lombok.Data;

import java.util.Map;

@Data
public class MarkScored {
    private Map<String, Double> markList;
}
