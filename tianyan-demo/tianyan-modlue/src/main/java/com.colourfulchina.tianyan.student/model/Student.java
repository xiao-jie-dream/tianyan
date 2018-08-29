package com.colourfulchina.tianyan.student.model;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Data
public class Student implements Serializable {


	private Integer id;

	private String name;

	private Integer age;

	private Integer gender;

	private Instant createTime;

	private Instant updateTime;
}
