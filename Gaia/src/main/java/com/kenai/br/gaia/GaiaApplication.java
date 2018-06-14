package com.kenai.br.gaia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class GaiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GaiaApplication.class, args);
	}
}
