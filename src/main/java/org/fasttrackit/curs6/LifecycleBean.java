package org.fasttrackit.curs6;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Component
public class LifecycleBean {
    private final int index;

    @Autowired
    LifecycleBean(@Value("${data.storage:FILE}") String dataStorageType) {
        this(-1);
        log.info("Data storage is {}", dataStorageType);
    }

    LifecycleBean(int index) {
        this.index = index;
        log.info("Called Constructor");
    }


    public int getIndex() {
        return index;
    }

    @PostConstruct
    void postConstruct() {
        log.info("Called postConstruct");
    }

    @PreDestroy
    void preDestroy() {
        log.info("Called predestroy");
    }
}
