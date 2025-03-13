package com.example.fitTrace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalancerAutoConfiguration;

@SpringBootApplication
public class FitTraceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitTraceApplication.class, args);
	}

}
