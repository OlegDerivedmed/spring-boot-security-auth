package com.derivedmed.mytown;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
@ComponentScan(basePackages = "com.derivedmed.mytown")
@EntityScan(basePackages = "com.derivedmed.mytown.entities")
@EnableJpaRepositories
public class MytownApplication {

    public static void main(String[] args) {
        SpringApplication.run(MytownApplication.class, args);
    }

}
