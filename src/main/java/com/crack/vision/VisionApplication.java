package com.crack.vision;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources(value = {
		@PropertySource("classpath:profiles/${spring.profiles.active}/application.properties")
})
public class VisionApplication {

	public static void main(String[] args) {
		SpringApplication.run(VisionApplication.class, args);
	}

}
