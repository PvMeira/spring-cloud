package com.kenai.br.library.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LibraryRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryRegisterApplication.class, args);
	}
}
