package com.backend.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket productApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.backend.ecommerce"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo getApiInfo(){
        Contact contact = new Contact("henock Mipoka", "http:dreesis.com","mipokahenock98@gmail.com");

        return new ApiInfoBuilder()
                .title("Ecommerce API")
                .description("Documentation Ecommerce Api")
                .version("1.0.0")
                .license("Apache 2.0")
                .contact(contact)
                .build();
    }
}
