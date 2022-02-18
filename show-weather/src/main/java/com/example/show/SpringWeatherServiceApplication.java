package com.example.show;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
// we gonna use a hystrix circuit breaker
@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableEurekaClient
public class SpringWeatherServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWeatherServiceApplication.class, args);
	}
}
