package org.fasttrackit.curs6.persons;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.fasttrackit.curs6.persons.exceptions.InvalidPersonException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository repository;

    public Page<Person> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Optional<Person> getPerson(int id) {
        return repository.findById(id);
    }

    public Person addPerson(Person person) {
        validatePerson(person);
        return repository.save(person);
    }

    private void validatePerson(Person person) {
        if (StringUtils.isEmpty(person.getName())) {
            throw new InvalidPersonException("Person doesn't have a name");
        }
    }

    public Optional<Person> deletePerson(int id) {
        var person = repository.findById(id);
        person.ifPresent(repository::delete);
        return person;
    }
}
