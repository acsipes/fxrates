package com.epam.fxrates.config;

import static springfox.documentation.builders.PathSelectors.regex;

import com.epam.fxrates.web.FxratesController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@ComponentScan(basePackageClasses = FxratesController.class)
@Configuration
public class SwaggerConfig {

    private static final String swaggerApiVersion = "1.0";
    private static final String licenceText       = "License";
    private static final String title             = "FxRates REST API";
    private static final String description       = "RESTful API for FxRates";

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .license(licenceText)
                .version(swaggerApiVersion)
                .build();
    }

    @Bean
    public Docket fxRatesApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")
                .select()
                .paths(regex("/fxrates.*"))
                .build();
    }
}
