package com.colourfulchina.tianyan.student.service;

import com.colourfulchina.tianyan.student.dao.StudentMapper;
import com.colourfulchina.tianyan.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl  implements StudentService   {

	@Autowired
	public StudentMapper studentMapper;

	@Override
	public Student getStudent() {
		Student student = studentMapper.getStudent();
		return student;
	}
}
