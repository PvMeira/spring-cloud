package com.kenai.br.hades;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HadesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HadesApplication.class, args);
	}
}
