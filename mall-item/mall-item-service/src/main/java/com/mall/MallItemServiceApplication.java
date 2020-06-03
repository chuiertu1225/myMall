package com.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.mall.item.mapper")
public class MallItemServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallItemServiceApplication.class);
    }
}
