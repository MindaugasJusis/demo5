package com.example.demo5.rest;

import lombok.*;
import com.example.demo5.rest.contracts.StudentDto;
import com.example.demo5.entities.Student;
import com.example.demo5.persistence.StudentsDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/students")
public class StudentsController {

    @Inject
    @Setter @Getter
    private StudentsDAO studentsDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Long id) {
        Student student = studentsDAO.findOne(id);
        if(student == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        StudentDto studentDto = new StudentDto();
        studentDto.setName(student.getName());
        studentDto.setSurname(student.getSurname());
        studentDto.setCourses(student.getCourses());
        studentDto.setBirthDate(student.getBirthDate());
        studentDto.setGroupNumber(student.getGroup().getNumber());

        return Response.ok(studentDto).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(
            @PathParam("id") final Long studentId,
            StudentDto studentDto) {
        try {
            Student exsistingStudent = studentsDAO.findOne(studentId);
            if (exsistingStudent == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            exsistingStudent.setName(studentDto.getName());
            exsistingStudent.setSurname(studentDto.getSurname());
            exsistingStudent.setCourses(studentDto.getCourses());
            exsistingStudent.setBirthDate(studentDto.getBirthDate());
            studentsDAO.update(exsistingStudent);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}
