package org.springside.examples.bootapi.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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
                registry.addMapping("/api/**")
                        .allowedMethods(HttpMethod.GET.name(),
                                        HttpMethod.POST.name(),
                                        HttpMethod.PATCH.name(),
                                        HttpMethod.PUT.name(),
                                        HttpMethod.DELETE.name()
                        );
            }
        	
        };
    }	
	
	@Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("5120MB");
        factory.setMaxRequestSize("5120MB");
        return factory.createMultipartConfig();
    }
}
