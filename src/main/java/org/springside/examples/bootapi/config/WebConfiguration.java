package org.springside.examples.bootapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 
 * @author wanhong
 * @date Mar 11, 2016
 */
@Configuration
public class WebConfiguration {
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
		
        return new WebMvcConfigurerAdapter() {
        
        	@Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**");
            }
        	
        };
    }	
}
