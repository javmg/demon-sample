package com.sample.demon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Value("${application.execute.in.background:true}")
    private boolean executeInBackground;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (executeInBackground) {

            log.info("Application running in background.");

            Thread.currentThread().join();
        }
    }
}
