package com.yazykov.projectf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.yazykov.projectf")
public class ProjectFirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectFirstApplication.class, args);
	}

}
