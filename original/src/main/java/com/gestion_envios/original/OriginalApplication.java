package com.gestion_envios.original;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@EntityScan
@ComponentScan  

@SpringBootApplication
public class OriginalApplication {

	public static void main(String[] args) {
		SpringApplication.run(OriginalApplication.class, args);
	}

}
