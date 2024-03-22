package com.i.minishopping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableJpaAuditing
@EnableAsync
@SpringBootApplication
public class MiniProjectApplication implements CommandLineRunner {

    protected static final Logger logger = LoggerFactory.getLogger(SpringApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MiniProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Good Luck!");
    }

}
