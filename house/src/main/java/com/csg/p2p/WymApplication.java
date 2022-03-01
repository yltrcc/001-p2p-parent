package com.csg.p2p;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class WymApplication {

    public static void main(String[] args) {
        SpringApplication.run(WymApplication.class, args);
    }

}
