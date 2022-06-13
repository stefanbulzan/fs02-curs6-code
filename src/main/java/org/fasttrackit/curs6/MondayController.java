package org.fasttrackit.curs6;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@Slf4j
@Profile("monday")
@RestController
@RequestMapping("monday")
public class MondayController {
    @GetMapping
    String today() {
        return "monday";
    }

    @PostConstruct
    void postConstruct() {
        log.info("Monday controller enabled");
    }

}
