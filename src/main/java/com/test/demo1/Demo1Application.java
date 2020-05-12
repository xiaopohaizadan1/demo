package com.test.demo1;

import net.hasor.spring.boot.EnableHasor;
import net.hasor.spring.boot.EnableHasorWeb;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@EnableHasor
@EnableHasorWeb
@MapperScan(value = "com.test.demo1.mybatis.mapper")
@SpringBootApplication
@PropertySources({
        @PropertySource("classpath:/config.properties"),
})
public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

}
