package org.adendrata.spring.tutorial.rest;

import org.adendrata.spring.tutorial.rest.entity.Person;
import org.adendrata.spring.tutorial.rest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private PersonRepository personRepository;

    @PostConstruct
    public void initData() {
        List<Person> persons = Arrays.asList(
                new Person("Jon", "Doe", Person.GenderType.MALE),
                new Person("Kim", "Li", Person.GenderType.FEMALE)
        );
        persons.forEach(personRepository::save);
    }
}
