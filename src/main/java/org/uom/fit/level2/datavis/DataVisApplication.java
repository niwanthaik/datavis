package org.uom.fit.level2.datavis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication

@Configuration
@EnableAutoConfiguration
@ComponentScan("org.uom.fit.level2.datavis")
public class DataVisApplication {

    private static final Logger log = LoggerFactory.getLogger(DataVisApplication.class);

    public static void main(String[] args) {
        log.info("starting the datavis application");
        SpringApplication.run(DataVisApplication.class, args);}

    public void run() {
    }
}
