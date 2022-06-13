package org.fasttrackit.curs6;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Random;

@Data
@Service
public class TuesdayService {
    private final RequestBean requestBean;
    private final int index;

    TuesdayService(RequestBean requestBean) {
        this.requestBean = requestBean;
        this.index = new Random().nextInt();
    }
}
