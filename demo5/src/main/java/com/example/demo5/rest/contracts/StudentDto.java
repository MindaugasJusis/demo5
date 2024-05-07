package com.example.demo5.rest.contracts;

import com.example.demo5.entities.Course;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class StudentDto {
    private String Name;
    private String Surname;
    private String BirthDate;
    private List<Course> Courses;
    private Integer GroupNumber;
}
