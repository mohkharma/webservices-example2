package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController

public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

//	@GetMapping("/mydetails")
//	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
//		return String.format("Hello %s!", name);
//	}

	/**
	 * a bean exploits the Inversion of Control feature by which an object defines its dependencies without creating them
	 * Spring @Bean annotation tells that a method produces a bean
	 * to be managed by the Spring container.
	 *
	 * @return RestTemplate instance
	 * @Bean is a method-level annotation and a direct analog of the XML <bean/> element.
	 * The annotation supports most of the attributes offered by <bean/> ,
	 * such as: init-method , destroy-method , autowiring , lazy-init , dependency-check , depends-on and scope .
	 */
	@Bean("restTemplate")
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
