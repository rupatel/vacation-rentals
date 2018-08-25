package com.neu.academic.travel.vacation.rentals.configs.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration  implements WebMvcConfigurer{
	@Override
	  public void addViewControllers(ViewControllerRegistry registry) {
		//forward / to index.html
		registry.addViewController("/")
                .setViewName("forward:/index.html");

		//forward /word to index.html
		registry.addViewController("/{x:\\w+}")
                .setViewName("forward:/index.html");
        
		// forward /word1/word2/.. to index.html where word1 not api
		registry.addViewController("/{x:(?!api).*}/**/{y:\\w+}")
                .setViewName("forward:/index.html");
	}
}