package org.fasttrackit.curs6;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@Slf4j
@Profile("tuesday")
@RestController
@RequestMapping("tuesday")
@RequiredArgsConstructor
public class TuesdayController {
    private final TuesdayService tuesdayService;

    @GetMapping
    String today(RequestBean bean) {
        System.out.println("test");
        return """
                tuesday 
                %s
                %s
                """.formatted(bean, tuesdayService);
    }

    @PostConstruct
    void postConstruct() {
        log.info("Tuesday controller enabled");
    }
}
