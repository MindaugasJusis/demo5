package com.example.demo5.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Course.findAll", query = "select t from Course as t")
})
public class Course {
    @GeneratedValue
    @Id
    private Long id;

    public Long getId() {
        return id;
    }
//    test

    public void setId(Long id) {
        this.id = id;
    }

    @Basic(optional = false)
    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Course)) return false;
        Course that = (Course) other;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
