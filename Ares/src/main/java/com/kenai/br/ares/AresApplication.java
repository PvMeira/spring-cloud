package com.kenai.br.ares;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class AresApplication {

	public static void main(String[] args) {
		SpringApplication.run(AresApplication.class, args);
	}
}
