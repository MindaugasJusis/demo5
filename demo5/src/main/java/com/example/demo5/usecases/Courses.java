package com.example.demo5.usecases;

import com.example.demo5.entities.Course;
import com.example.demo5.persistence.CoursesDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Courses {
    @Inject
    private CoursesDAO coursesDAO;

    @Getter
    @Setter
    private Course courseToCreate = new Course();

    @Getter
    private List<Course> allCourses;

    @PostConstruct
    public void init(){
        loadAllCourses();
    }

    @Transactional
    public void createCourse() {
        this.coursesDAO.persist(courseToCreate);
    }

    private void loadAllCourses() {
        this.allCourses = coursesDAO.loadAll();
    }
}
