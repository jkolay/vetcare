package com.app.vetcare;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Mortgage check API", version = "1.0", description = "Mortgage check API"))
public class VetcareApplication {

	public static void main(String[] args) {
		SpringApplication.run(VetcareApplication.class, args);
	}

}
