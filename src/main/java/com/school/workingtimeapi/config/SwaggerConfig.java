package com.school.workingtimeapi.config;

import org.springframework.context.annotation.Configuration;

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
