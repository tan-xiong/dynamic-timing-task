package com.tx.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author tx
 */
@EnableScheduling
@SpringBootApplication
public class DynamicTimingTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicTimingTaskApplication.class, args);
    }

}
