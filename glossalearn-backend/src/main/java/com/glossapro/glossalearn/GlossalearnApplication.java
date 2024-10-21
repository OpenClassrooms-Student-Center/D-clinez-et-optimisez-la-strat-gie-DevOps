package com.glossapro.glossalearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class GlossalearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlossalearnApplication.class, args);
	}

}
