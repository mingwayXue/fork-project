package com.xue.myblog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())		//swagger头信息
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.xue.myblog.controller"))		//controller包扫描
				.paths(PathSelectors.any())		//表示swagger拦截所有路径
//				.paths(PathSelectors.none())
				.build()
//				.enable(false)		//是否开启swagger（一般用于生产环境）
				;
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("myblog")
				.description("myblog")
				.termsOfServiceUrl("")
				//.contact(contact)
				.version("0.0.1")
				.build();
	}

}