package com.ye.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.ye.springcloud"})
public class Consumer_80_feigh {
    public static void main(String[] args) {
        SpringApplication.run(Consumer_80_feigh.class,args);
    }
}
