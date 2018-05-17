package com.swdegao.quartz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@SpringBootApplication
@EnableAutoConfiguration
@MapperScan({"com.swdegao.quartz.mapper"})
public class SwdegaoQuartzDealdataApplication {
	/**
	 * 在这里我们使用@Bean注入 fastJsonHttpMessageConvert
	 * fastjson第三方部署
	 * @return
	 */
    @Bean
    public HttpMessageConverters fashJsonHttpMessageConverters(){
        FastJsonHttpMessageConverter fastConverter=new FastJsonHttpMessageConverter();
         
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
         
        fastConverter.setFastJsonConfig(fastJsonConfig);
        HttpMessageConverter<?> converter =fastConverter;
         
        return new HttpMessageConverters(converter);
         
    }
    
	public static void main(String[] args) {
		SpringApplication.run(SwdegaoQuartzDealdataApplication.class, args);
		System.out.println("项目启动");
	}
}
