package com.example.demo5.usecases;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.example.demo5.entities.StudyGroup;
import lombok.Getter;
import lombok.Setter;
import com.example.demo5.persistence.StudentsDAO;
import com.example.demo5.persistence.StudyGroupsDAO;
import com.example.demo5.entities.Student;

@Model
public class StudentsForGroup implements Serializable {

    @Inject
    private StudyGroupsDAO studyGroupsDAO;

    @Inject
    private StudentsDAO studentsDAO;

    @Getter @Setter
    private StudyGroup studyGroup;

    @Getter @Setter
    private Student studentToCreate = new Student();

    @Getter @Setter
    private List<String> selectedCourseNames;

    @PostConstruct
    public void init(){
        System.out.println("StudentsForGroup INIT CALLED");
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        if (requestParameters.get("studyGroupId") != null) {
            Long studyGroupId = Long.parseLong(requestParameters.get("studyGroupId"));
            this.studyGroup = studyGroupsDAO.findOne(studyGroupId);
        }
    }

    @Transactional
    public void createStudent() {
        studentToCreate.setGroup(this.studyGroup);
        studentsDAO.persist(studentToCreate);
    }
}
