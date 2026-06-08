package com.vipin.validationdemo.controller;

import com.vipin.ValidationDemo.dto.StudentRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    @PostMapping
    public String createStudent(@Valid @RequestBody StudentRequest request) {

        return "Student Registered Successfully";
    }
}