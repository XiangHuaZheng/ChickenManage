package com.hua.chick;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.hua.chick.chicken.dao")
@SpringBootApplication
public class ChickManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChickManageApplication.class, args);
    }

}
