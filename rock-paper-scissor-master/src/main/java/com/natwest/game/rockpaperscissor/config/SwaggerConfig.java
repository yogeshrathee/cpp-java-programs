package com.natwest.game.rockpaperscissor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(
                        new ApiInfo(
                                "GAME: ROCK, PAPER and SCISSORS",
                                "RESTFull APIs",
                                "0.0.1",
                                null,
                                new Contact(
                                        "Developer",
                                        null,
                                        "yogesh.rathee7400@gmail.com"),
                                null,
                                null,
                                new ArrayList<>()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.natwest.game.rockpaperscissor"))
                .build();
    }
}
