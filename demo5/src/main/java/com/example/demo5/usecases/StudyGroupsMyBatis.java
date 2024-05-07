package com.example.demo5.usecases;

import com.example.demo5.mybatis.dao.StudyGroupMapper;
import com.example.demo5.mybatis.model.StudyGroup;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class StudyGroupsMyBatis {
    @Inject
    private StudyGroupMapper studygroupMapper;

    @Getter
    private List<com.example.demo5.entities.StudyGroup> allStudyGroups;

    @Getter@Setter
    private com.example.demo5.entities.StudyGroup studyGroupToCreate = new com.example.demo5.entities.StudyGroup();

    @PostConstruct
    public void init() {
        this.loadAllStudyGroups();
    }

    private void loadAllStudyGroups() {
        this.allStudyGroups = studygroupMapper.selectAll();
    }

    @Transactional
    public String createStudyGroup() {
        studygroupMapper.insert(studyGroupToCreate);
        return "/myBatis/studyGroups?faces-redirect=true";
    }
}
