package com.example.demo5.persistence;

import com.example.demo5.entities.StudyGroup;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class StudyGroupsDAO {
    @Inject
    private EntityManager entityManager;

    public List<StudyGroup> loadAll() {
        return entityManager.createNamedQuery("StudyGroup.findAll", StudyGroup.class).getResultList();
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void persist(StudyGroup studyGroup) {
        this.entityManager.persist(studyGroup);
    }

    public StudyGroup findOne(Long id) {
        return entityManager.find(StudyGroup.class, id);
    }
}
