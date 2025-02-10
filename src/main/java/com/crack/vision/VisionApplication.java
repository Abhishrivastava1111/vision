package com.crack.vision;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*@PropertySources(value = {
		@PropertySource("classpath:profiles/${spring.profiles.active}/application.properties")
})*/
public class VisionApplication {

	public static void main(String[] args) {
		System.out.println("Staring the SpringBoot application at line");
		SpringApplication.run(VisionApplication.class, args);
	}

}
