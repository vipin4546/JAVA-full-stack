package com.vipin.StudentManagement.controller;

import com.vipin.StudentManagement.entity.Student;
import com.vipin.StudentManagement.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student")
    public String studentPage(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);


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

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam Long id) {
        studentService.deleteStudent(id);
        return "redirect:/student";
    }

    @GetMapping("/edit")
    public String editStudent(@RequestParam Long id, Model model) {
        Student student =
                studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "edit-student";
    }

    @PostMapping("/update")
    public String updateStudent(@RequestParam Long id,
                                @RequestParam String name,
                                @RequestParam String studentClass,
                                @RequestParam Integer rollNumber) {
        Student student =
                studentService.getStudentById(id);
        student.setName(name);
        student.setStudentClass(studentClass);
        student.setRollNumber(rollNumber);
        studentService.saveStudent(student);
        return "redirect:/student";
    }

}
