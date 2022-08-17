package com.sinaukoding21.perpustakaan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(springfox.documentation.spi.DocumentationType.SWAGGER_2)
                .securitySchemes(Collections.singletonList(securityScheme()))
                .securityContexts(Collections.singletonList(securityContext()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sinaukoding21.perpustakaan.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Perpustakaan API",
                "Perpustakaan API Documentation",
                "1.0",
                "Terms of service",
                new Contact("MahessaGintara", "https://www.linkedin.com/in/mahessa-gintara-a9a8a817b/", "mahessagintara@gmail.com"),
                "",
                "",
                new ArrayList<>()
        );
        return apiInfo;
    }

    private SecurityScheme securityScheme(){
        return new ApiKey("Token", "Authorization", "header");
    }

    private SecurityContext securityContext(){
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "accessEverything");

        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;

        return Collections.singletonList(
                new SecurityReference("Token", authorizationScopes));
    }
}
