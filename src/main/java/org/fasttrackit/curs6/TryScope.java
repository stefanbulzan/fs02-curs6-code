package org.fasttrackit.curs6;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class TryScope {

    @Bean
    LifecycleBean firstTry(SingletonBean bean) {
        log.info("singleton bean is {}", bean);
        return new LifecycleBean(bean.index());
    }

    @Bean
    LifecycleBean secondTry(SingletonBean bean) {
        log.info("singleton bean is {}", bean);
        return new LifecycleBean(3);
    }

    @Bean
    LifecycleBean prototypeTry(PrototypeBean bean) {
        log.info("prototype is {}", bean);
        return new LifecycleBean(4);
    }

    @Bean
    LifecycleBean prototypeTry2(PrototypeBean bean) {
        log.info("prototype is {}", bean);
        return new LifecycleBean(4);
    }
}
