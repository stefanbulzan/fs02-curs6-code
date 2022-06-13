package org.fasttrackit.curs6;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Random;

@Slf4j
@Data
@Component
@RequestScope
public class RequestBean {
    private final int index;

    @Autowired
    RequestBean() {
        this.index = new Random().nextInt();
        log.info("Created request scope!");
    }
}
