package com.example.board.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class StaticResourceConfig extends WebMvcConfigurerAdapter{

	@Value("${static.resource.location}")
	private String staticResouceLocation;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
		registry.addResourceHandler("/upload/**").addResourceLocations(staticResouceLocation);
	}
}