

package com.colourfulchina.tianyan.gateway;


import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 *
 * 网关应用
 */
@SpringCloudApplication
public class TianyanGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(TianyanGatewayApplication.class, args);
	}
}
