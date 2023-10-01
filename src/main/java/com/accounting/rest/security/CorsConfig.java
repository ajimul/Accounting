package com.accounting.rest.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("https://spotsolution.store", "http://localhost:4200/")
				.allowedMethods("*") // Specify
				// allowed
				// methods
				.allowedHeaders("*") // Specify allowed headers
				.allowedHeaders("Authorization", "Content-Type");// Specify allowed headers
//          .allowCredentials(true); // Enable credentials if needed
	}
}
