package org.fasttrackit.curs6.persons;

import com.devskiller.jfairy.Fairy;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class PersonDataProvider implements CommandLineRunner {
    private final PersonRepository repository;

    @Override
    public void run(String... args) throws Exception {
        IntStream.range(0, 1000)
                .mapToObj(index -> Fairy.create().person())
                .map(person -> new Person(person.getFullName(), person.getAge()))
                .toList()
                .forEach(repository::save);
    }
}
