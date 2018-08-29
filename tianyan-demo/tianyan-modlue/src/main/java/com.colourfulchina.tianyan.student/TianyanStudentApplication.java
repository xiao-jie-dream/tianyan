package com.colourfulchina.tianyan.student;


import com.google.gson.internal.Excluder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 用户统一管理系统
 */
@EnableFeignClients
@SpringCloudApplication
public class TianyanStudentApplication {
	public static void main(String[] args) {
		SpringApplication.run(TianyanStudentApplication.class, args);
	}
}
