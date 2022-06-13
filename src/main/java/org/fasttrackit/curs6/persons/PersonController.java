package org.fasttrackit.curs6.persons;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.curs6.persons.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService service;

    @GetMapping
    CollectionResponse<Person> getAll(Pageable pageable) {
        Page<Person> page = service.getAll(pageable);
        return CollectionResponse.<Person>builder()
                .content(page.getContent())
                .pageInfo(PageInfo.builder()
                        .currentPage(page.getPageable().getPageNumber())
                        .pageSize(page.getSize())
                        .totalElements(page.getNumberOfElements())
                        .totalPages(page.getTotalPages())
                        .build())
                .build();
    }

    @GetMapping("{id}")
    Person getPerson(@PathVariable int id) {
        return service.getPerson(id)
                .orElseThrow(() -> new ResourceNotFoundException("Persons with id %s doesn't exist".formatted(id)));
    }

    @PostMapping
    Person addPerson(@RequestBody Person person) {
        return service.addPerson(person);
    }

    @DeleteMapping("{id}")
    Person deletePerson(@PathVariable int id) {
        return service.deletePerson(id)
                .orElse(null);
    }
}

