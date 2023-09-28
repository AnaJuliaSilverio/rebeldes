package com.zup.rebeldes;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "sistema para compartilhar recursos entre os rebeldes.", version = "1", description = " uma API, que irá armazenar informação sobre os rebeldes, bem como os recursos que eles possuem."))
public class RebeldesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RebeldesApplication.class, args);
	}

}
