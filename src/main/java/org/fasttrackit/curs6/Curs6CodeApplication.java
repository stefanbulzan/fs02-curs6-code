package org.fasttrackit.curs6;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
@EnableConfigurationProperties(value = MyConfig.class)
public class Curs6CodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(Curs6CodeApplication.class, args);
    }

    @Bean
    CommandLineRunner atStartup(LifecycleBean instance3, MyConfig config) {
        return args -> {
            log.info("config is {}", config);
            log.info("Instance " + instance3.getIndex());
        };
    }

    @Bean
    LifecycleBean instance1() {
        return new LifecycleBean(1);
    }

    @Bean
    LifecycleBean instance2() {
        return new LifecycleBean(2);
    }

    @Bean
    LifecycleBean instance3() {
        return new LifecycleBean(3);
    }
}
