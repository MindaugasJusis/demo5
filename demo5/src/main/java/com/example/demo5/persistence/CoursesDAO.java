package com.example.demo5.persistence;

import com.example.demo5.entities.Course;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class CoursesDAO {
    @Inject
    private EntityManager entityManager;

    public void persist(Course course) {
        this.entityManager.persist(course);
    }

    public Course findOne(Long id) {
        return entityManager.find(Course.class, id);
    }

    public List<Course> loadAll() {
        return entityManager.createNamedQuery("Course.findAll", Course.class).getResultList();
    }
}
