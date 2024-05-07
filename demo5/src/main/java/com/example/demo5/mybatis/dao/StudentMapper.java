package com.example.demo5.mybatis.dao;

import com.example.demo5.mybatis.model.Student;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STUDENT
     *
     * @mbg.generated Sun Mar 17 20:51:49 EET 2024
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STUDENT
     *
     * @mbg.generated Sun Mar 17 20:51:49 EET 2024
     */
    int insert(Student record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STUDENT
     *
     * @mbg.generated Sun Mar 17 20:51:49 EET 2024
     */
    Student selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STUDENT
     *
     * @mbg.generated Sun Mar 17 20:51:49 EET 2024
     */
    List<Student> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STUDENT
     *
     * @mbg.generated Sun Mar 17 20:51:49 EET 2024
     */
    int updateByPrimaryKey(Student record);
}