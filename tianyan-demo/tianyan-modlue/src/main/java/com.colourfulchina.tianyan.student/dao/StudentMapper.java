package com.colourfulchina.tianyan.student.dao;

import com.colourfulchina.tianyan.student.model.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {

	public Student getStudent();
}
