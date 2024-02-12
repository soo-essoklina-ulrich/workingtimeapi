package com.school.workingtimeapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.oas.annotations.EnableOpenApi;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

/*    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.regex("/.*"))
                .apis(RequestHandlerSelectors.basePackage("com.school.workingtimeapi"))
                .build()
                .apiInfo(apiInfo());

    }*/
/*    private ApiInfo apiInfo(){
        return new ApiInfo(
                "Working Time API",
                "API for managing school working time",
                "1.0",
                "Terms of service",
                new Contact("Working Time API", "http://localhost:8081/timeapiv1", "sessoklinaulrich870@gmail.com"),
                "License of API",
                "API license URL",
                Collections.emptyList()
        );
    }*/
}
