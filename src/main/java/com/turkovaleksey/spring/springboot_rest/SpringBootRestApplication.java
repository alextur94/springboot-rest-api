package com.turkovaleksey.spring.springboot_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootRestApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApplication.class, args);
	}

//	@Bean
//	public WebMvcConfigurer corsConfig() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**")
//						.allowedOrigins("http://localhost:3000");
//			}
//		};
//	}
}
