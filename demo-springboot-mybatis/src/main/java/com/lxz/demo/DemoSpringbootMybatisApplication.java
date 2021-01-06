package com.lxz.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
/**
 * @Title: DemoSpringbootMybatisApplication
 * @Description: 启动类
 *
 * @param null
 * @return:    null
 * @throws
 * @author: liuxuanzhi
 * @Date:  2020/12/31/8:57
 */


public class DemoSpringbootMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringbootMybatisApplication.class, args);
    }

}
