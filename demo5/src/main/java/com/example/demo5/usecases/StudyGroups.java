package com.example.demo5.usecases;

import com.example.demo5.entities.StudyGroup;
import lombok.Getter;
import lombok.Setter;
import com.example.demo5.persistence.StudyGroupsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class StudyGroups {

    @Inject
    private StudyGroupsDAO studyGroupsDAO;

    @Getter @Setter
    private StudyGroup studyGroupToCreate = new StudyGroup();

    @Getter
    private List<StudyGroup> allStudyGroups;

    @PostConstruct
    public void init(){
        loadAllStudyGroups();
    }

    @Transactional
    public void createStudyGroup() {
        this.studyGroupsDAO.persist(studyGroupToCreate);
    }

    private void loadAllStudyGroups() {
        this.allStudyGroups = studyGroupsDAO.loadAll();
    }
}
