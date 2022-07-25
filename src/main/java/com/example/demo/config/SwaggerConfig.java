package com.example.demo.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final String AUTHORIZATION_HEADER = "Authorization";
	private static final String BASIC_AUTH = "basicAuth";
	private static final String BEARER_AUTH = "Bearer";

	@Bean
	Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.securityContexts(Arrays.asList(securityContext()))
				.securitySchemes(Arrays.asList(apiKey()))
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}

//	private ApiInfo apiInfo() {
//		return new ApiInfoBuilder().title("Employee API")
//				.description("Employee API reference for developers")
//				.terms 
//	}

	private ApiKey apiKey() {
		return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
	}

//	 @SuppressWarnings("deprecation")
//	private SecurityContext securityContext() {
//	        return SecurityContext.builder()
//	        		.securityReferences(List.of(basicAuthReference(), bearerAuthReference()))
//	        		.forPaths(PathSelectors.any()).build();
//	    }
//	 
//	    private SecurityReference basicAuthReference() {
//	        return new SecurityReference(BASIC_AUTH, new AuthorizationScope[0]);
//	    }
//	 
//	    private SecurityReference bearerAuthReference() {
//	        return new SecurityReference(BEARER_AUTH, new AuthorizationScope[0]);
//	    }
	    
	    private SecurityContext securityContext() {
			return SecurityContext.builder().securityReferences(defaultAuth()).build();
		}
	private List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
	}
}
