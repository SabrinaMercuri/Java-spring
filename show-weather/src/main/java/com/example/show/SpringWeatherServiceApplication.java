package com.example.show;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
// we gonna use a hystrix circuit breaker
@EnableHystrixDashboard
@EnableCircuitBreaker
public class SpringWeatherServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWeatherServiceApplication.class, args);
	}
}
