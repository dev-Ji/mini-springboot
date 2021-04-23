package com.example.board.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class StaticResourceConfig extends WebMvcConfigurerAdapter{

	@Value("${static.resource.location}")
	private String staticResouceLocation;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler("/**").addResourceLocations("classpath:/webjars/");
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
		registry.addResourceHandler("/**").addResourceLocations("classpath:/public");
		
		registry.addResourceHandler("/**").addResourceLocations("classpath:/resources/");
		registry.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/resources");
		
		
		registry.addResourceHandler("/upload/**").addResourceLocations(staticResouceLocation);
		
		   registry.addResourceHandler("/webjars/**")
           .addResourceLocations("/webjars/")
           .resourceChain(false);
   registry.setOrder(1);
	}
}
