package com.vipin.ValidationDemo.dto;

import jakarta.validation.constraints.Min;

public class StudentRequest {

    @Min(value = 18, message = "Age must be at least 18")
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}