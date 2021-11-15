package com.javaquery.sas.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author vicky.thakor
 * @since 1.0.0
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.javaquery.sas.discovery"})
@EnableMongoRepositories("com.javaquery.sas.discovery.model.mongodb.repositories")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
