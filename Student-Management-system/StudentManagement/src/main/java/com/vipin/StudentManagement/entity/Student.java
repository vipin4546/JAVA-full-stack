package com.vipin.StudentManagement.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String studentClass;

    private Integer rollnumber;

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;

    }

    public Integer getRollNumber() {
        return rollnumber;
    }

    public void setRollNumber(Integer rollnumber) {
        this.rollnumber = rollnumber;

    }

    public Long getId() {
        return id;
    }

}
