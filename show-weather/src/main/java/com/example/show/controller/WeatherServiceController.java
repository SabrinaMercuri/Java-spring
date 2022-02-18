package com.example.show.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@RestController
public class WeatherServiceController {
	

    @Autowired
    RestTemplate restTemplate;

    ///récupération de la météo avec la ville
    @HystrixCommand(fallbackMethod = "callStudentServiceAndGetData_Fallback")
    @GetMapping ("/getWeatherDetailsByName2/{villeName}")
    public String getDetailsWeatherBycity(@PathVariable String villeName) {
        String response = restTemplate
                .exchange("http://localhost:8098/getWeatherDetailsByName/{villeName}"
                        , HttpMethod.GET
                        , null
                        , new ParameterizedTypeReference<String>() {
                        }, villeName).getBody();
        return response;
    }

    ///récupération de la météo avec le code postal
    @HystrixCommand(fallbackMethod = "callStudentServiceAndGetData_Fallback")
    @GetMapping ("/getWeatherDetailsByZip2/{zip}")
    public String getDetailsWeatherByZip2(@PathVariable String zip) {
        String response = restTemplate
                .exchange("http://localhost:8098/getWeatherDetailsByZip/{zip}"
                        , HttpMethod.GET
                        , null
                        , new ParameterizedTypeReference<String>() {
                        }, zip).getBody();
        return response;
    }

    private String callStudentServiceAndGetData_Fallback(String villeName) {
        System.out.println("Student Service is down!!! fallback route enabled...");
        return "CIRCUIT BREAKER ENABLED!!!No Response From Weather Service at this moment. Service will be back shortly - " + new Date();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

