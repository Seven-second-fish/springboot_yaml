package com.hkd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hkd.mapper")
public class SpringbootYamlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootYamlApplication.class, args);
	}

}
