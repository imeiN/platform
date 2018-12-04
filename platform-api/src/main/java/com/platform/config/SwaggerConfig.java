package com.platform.config;


import com.platform.util.AppConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableWebMvc
@EnableSwagger2
@ComponentScan(basePackages="com.platform.api")
public class SwaggerConfig {

    @Bean
    public BeanContextAware beanContextAware() {
        return new BeanContextAware();
    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("/(" + AppConstants.SERVICE_NAME + "/).*"))
                .build()
                .apiInfo(apiInfo())
                .enable(true)
                .useDefaultResponseMessages(false);
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("小程序接口文档", "http://www.framework.com/", "framework@qq.com");
        return new ApiInfoBuilder()
                .title("framework")
                .description("framework")
                .termsOfServiceUrl("http://www.framework.com/")
                .contact(contact)
                .version("0.1")
                .build();
    }

}