package com.platform;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by linyisheng on 2018/12/4.
 */
@SpringBootApplication
@Slf4j
@EnableFeignClients
@EnableDiscoveryClient
@EnableScheduling
@EnableAspectJAutoProxy(exposeProxy = true, proxyTargetClass = true)
public class ApiApplication {
    public static void main (String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}
