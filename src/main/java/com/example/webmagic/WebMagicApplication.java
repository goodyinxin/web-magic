package com.example.webmagic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.example.webmagic"})
@SpringBootApplication
public class WebMagicApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebMagicApplication.class, args);
	}
}
