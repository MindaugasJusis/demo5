package com.example.demo5.usecases;

import com.example.demo5.entities.Student;
import com.example.demo5.persistence.StudentsDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter
@Setter
public class UpdateStudentDetails implements Serializable {
    private Student student;

    @Inject
    private StudentsDAO studentsDAO;

    @PostConstruct
    private void init() {
        System.out.println("UpdateStudentDetails INIT CALLED");
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long studentId = Long.parseLong(requestParameters.get("studentId"));
        this.student = studentsDAO.findOne(studentId);
    }

    @Transactional
    public String updateStudentBirthDate() {
        try {
            studentsDAO.update(this.student);
        } catch (OptimisticLockException e) {
            return "/studentDetails.xhtml?faces-redirect=true&studentId=" + this.student.getId() + "&error=optimistic-lock-exception";
        }
        return "students.xhtml?studentGroupId=" + this.student.getGroup().getId() + "&faces-redirect=true";
    }
}
