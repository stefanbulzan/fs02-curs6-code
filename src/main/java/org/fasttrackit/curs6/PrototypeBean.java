package org.fasttrackit.curs6;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Slf4j
@Component
@Scope(SCOPE_PROTOTYPE)
public record PrototypeBean(int index) {
    PrototypeBean() {
        this(new Random().nextInt());
        log.info("Instantiated prototype bean");
    }
}
