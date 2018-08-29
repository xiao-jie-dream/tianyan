package com.colourfulchina.tianyan.admin;


import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 用户统一管理系统
 */
@EnableFeignClients
@SpringCloudApplication
public class TianyanAdminApplication {
	public static void main(String[] args) {
		SpringApplication.run(TianyanAdminApplication.class, args);
	}
}
