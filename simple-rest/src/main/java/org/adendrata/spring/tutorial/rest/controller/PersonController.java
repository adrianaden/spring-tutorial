package org.adendrata.spring.tutorial.rest.controller;

import org.adendrata.spring.tutorial.rest.entity.Person;
import org.adendrata.spring.tutorial.rest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Person> findOne(@PathVariable("id") Long id) {
        return ResponseEntity.ok(personService.findOne(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Person> create(@RequestBody @Validated Person person) {
        return ResponseEntity.ok(personService.create(person));
    }

    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Person> replace(@RequestBody Person person, @PathVariable("id") Long id) {
        return ResponseEntity.ok(personService.replace(person, id));
    }

    @PatchMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Person> patch(@RequestBody Person person, @PathVariable("id") Long id) {
        return ResponseEntity.ok(personService.patch(person, id));
    }

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> delete(@PathVariable("id") Long id) {
        personService.delete(id);
        return ResponseEntity.ok("DELETED");
    }
}
