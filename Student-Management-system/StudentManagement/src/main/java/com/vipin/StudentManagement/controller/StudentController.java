package com.vipin.StudentManagement.controller;

import com.vipin.StudentManagement.entity.Student;
import com.vipin.StudentManagement.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student")
    public String studentPage() {
        return "student";
    }

    @PostMapping("/student")
    public String addStudent(
            @RequestParam String name,
            @RequestParam String studentClass,
            @RequestParam Integer rollNumber

    ) {
        Student student = new Student();
        student.setName(name);
        student.setStudentClass(studentClass);
        student.setRollNumber(rollNumber);
        studentService.saveStudent(student);
        return "redirect:/student";

    }

}
