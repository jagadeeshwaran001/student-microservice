package com.nector.apiGateWay.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/fallback/student")
    public ResponseEntity<String> studentFallback() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("Student Service is temporarily unavailable.");
    }

    @GetMapping("/fallback/course")
    public ResponseEntity<String> courseFallback() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("Course Service is temporarily unavailable.");
    }
}
