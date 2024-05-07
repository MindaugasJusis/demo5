package com.example.demo5.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Student.findAll", query = "select t from Student as t")
})
public class Student {
    @Id
    @GeneratedValue
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Basic(optional = false)
    @Column(name = "kitaip")
    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Basic(optional = false)
    private String Surname;

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    @Basic(optional = false)
    private String BirthDate;

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String birthDate) {
        BirthDate = birthDate;
    }

    @ManyToOne()
    private StudyGroup studyGroup;

    public StudyGroup getGroup() {
        return studyGroup;
    }

    public void setGroup(StudyGroup studyGroup) {
        this.studyGroup = studyGroup;
    }

    @ManyToMany
    private List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
