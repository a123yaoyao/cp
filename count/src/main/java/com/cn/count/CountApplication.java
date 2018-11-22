package com.cn.count;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@MapperScan("com.cn.count.dao")//将项目中对应的mapper类的路径加进来就可以了
public class CountApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountApplication.class, args);

	}
}
