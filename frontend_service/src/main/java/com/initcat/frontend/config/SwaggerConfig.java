package com.initcat.frontend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SwaggerConfig配置
 *
 * @author libo
 * @package com.initcat.frontend.config
 * @company xmiles
 * @date 2019/5/5
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.initcat.frontend"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("AD SERVICE API PROTOCOL")
                .description("Spring Boot 使用 Swagger2 构建RESTFUL API")
                .termsOfServiceUrl("http://www.github.com/kongchen/swagger-maven-plugin")
                .contact(new Contact("initcat", "http://initcat.cn", "destway@163.com.cn"))
                .version("1.0")
                .build();
    }

}
