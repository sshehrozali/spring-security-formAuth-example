package com.my.app.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1")
public class StudentController {
    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId) {

    }
}
