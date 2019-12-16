package io.corp.calculator.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {

	@Bean
    public Docket proFoodDocketSwaggerDevelopEndpoint() {
		return buildDocket().enable(true);
    }
 
    public ApiInfo buildProFoodApiInfo() {
        return new ApiInfoBuilder()
                .title("Calculator Online REST api")
                .description("PoC of a REST api, Calculator")
                .license("Apache License Version 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0.0")
                .build();
    }
	
	private Docket buildDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
                .groupName("api-pro-food")
                .apiInfo(buildProFoodApiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
	}

}
