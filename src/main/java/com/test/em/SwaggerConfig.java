package com.test.em;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
    String groupName = "Swagger";
       return new Docket(DocumentationType.SWAGGER_2).select()
          .apis(RequestHandlerSelectors.basePackage("com.test.em.controller"))
          .paths(PathSelectors.any())
          .build()
          .groupName(groupName)
          .apiInfo(apiInfo());
    }
   
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Employee Management API")
                .description("Employee Management API")
                .version("1.0.0")
                .license("TEST")
                .build();
    }
}

