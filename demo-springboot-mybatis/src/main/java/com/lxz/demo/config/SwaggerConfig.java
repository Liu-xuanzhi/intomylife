package com.lxz.demo.config;/****************************************************
 * 创建人：     @author liuxuanzhi    
 * 创建时间: 2020/12/30/11:45
 * 项目名称：  demo-springboot-mybatis
 * 文件名称: com.lxz.demo.config
 * 文件描述: @Description: Swagger配置类
 *
 * All rights Reserved, Designed By 财富管理部
 * @Copyright:2016-2020
 *
 ********************************************************/

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 包名称： com.lxz.demo.config
 * 类名称：SwaggerConfig
 * 类描述：Swagger配置类
 * 创建人：@author liuxuanzhi
 * 创建时间：2020/12/30/11:45
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("分布式任务系统") // 如果配置多个文档的时候，那么需要配置groupName来分组标识
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lxz.demo"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 用于定义API主界面的信息，比如可以声明所有的API的总标题、描述、版本
     * @return ApiInfoBuilder
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("学生信息API")
                .description("学生信息SwaggerAPI管理")
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }
}

