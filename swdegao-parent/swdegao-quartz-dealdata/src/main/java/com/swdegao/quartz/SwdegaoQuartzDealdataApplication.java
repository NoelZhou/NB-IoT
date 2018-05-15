package com.swdegao.quartz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({"com.swdegao.quartz.mapper"})
@MapperScan({"com.swdegao.quartz.mapper"})
public class SwdegaoQuartzDealdataApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwdegaoQuartzDealdataApplication.class, args);
		System.out.println("项目启动");
	}
}
