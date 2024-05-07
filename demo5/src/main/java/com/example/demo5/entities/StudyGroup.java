package com.example.demo5.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@NamedQueries({
        @NamedQuery(name = "StudyGroup.findAll", query = "select t from StudyGroup as t")
})
public class StudyGroup {





    @Basic(optional = false)
    private Integer Number;
    @Id
    @GeneratedValue
    private Long id;

    public Integer getNumber() {
        return Number;
    }

    public void setNumber(Integer number) {
        Number = number;
    }

    @OneToMany(mappedBy = "studyGroup")
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Basic
    private Integer Year;

    public Integer getYear() {
        return Year;
    }

    public void setYear(Integer year) {
        Year = year;
    }

    @Getter@Setter
    private String name;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
