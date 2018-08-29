

package com.colourfulchina.tianyan.monitor;


import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * 监控中心
 */
@EnableAdminServer
@SpringBootApplication
public class TianyanMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TianyanMonitorApplication.class, args);
	}
}
