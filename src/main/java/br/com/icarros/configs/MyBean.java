package br.com.icarros.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyBean {

    @Scope("prototype")
    @Bean
    public RestTemplate createRestTemplate(){
        return new RestTemplate();
    }

    @Scope("prototype")
    @Bean
    public ObjectMapper createObjectMapper(){
        return new ObjectMapper();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry){
                registry.addMapping("/").allowedOrigins("*");
            }
        };

    }

}
