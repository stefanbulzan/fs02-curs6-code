package org.fasttrackit.curs6;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Slf4j
@Component
public record SingletonBean(int index) {
    @Autowired
    SingletonBean(PrototypeBean bean) {
        this(new Random().nextInt());
        log.info("Constructing singleton bean {}", bean);
    }
}
