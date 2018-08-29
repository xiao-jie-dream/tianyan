package com.colourfulchina.tianyan.student.controller;

import com.colourfulchina.tianyan.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.colourfulchina.tianyan.student.service.StudentService;

@RestController
@RequestMapping("/test/student")
public class StudentController {

	@Autowired
	private StudentService studentService;


	@RequestMapping(value = "/student",method = RequestMethod.GET)
	public Student getStudent(){
		Student student = studentService.getStudent();
		return  student;
	}
}
