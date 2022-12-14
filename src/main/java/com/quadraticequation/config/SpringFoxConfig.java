package com.quadraticequation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {
    @Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("api")
                .apiInfo(apiInfo())
                .select()
                .paths(PathSelectors.ant("/api/**"))
                .apis(RequestHandlerSelectors.any())
                .build();
    }

    private ApiInfo apiInfo()
    {
        return new ApiInfo(
                "Quadratic Equation API",
                "API for test app",
                "version-1",
                "Free to use",
                new Contact("Ilia","@imoskxvx","imoskalenkoxvx@gmail.com"),
                "API License",
                "API License URL",
                Collections.emptyList());
    }
}
