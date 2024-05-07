package com.example.demo5.persistence;

import com.example.demo5.entities.Student;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class StudentsDAO {

    @Inject
    private EntityManager entityManager;

    public void persist(Student student) {
        this.entityManager.persist(student);
    }

    public Student findOne(Long id) {
        return entityManager.find(Student.class, id);
    }

    public List<Student> loadAll() {
        return entityManager.createNamedQuery("Student.findAll", Student.class).getResultList();
    }

    public Student update(Student student) {
        return entityManager.merge(student);
    }
}
