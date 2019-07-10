package com.yy.provider1;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@EnableDubbo
@SpringBootApplication
public class DubboProvider1Application {

    public static void main(String[] args) {
        SpringApplication.run(DubboProvider1Application.class, args);
    }



}
