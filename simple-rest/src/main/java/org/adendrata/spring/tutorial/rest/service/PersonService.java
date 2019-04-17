package org.adendrata.spring.tutorial.rest.service;

import org.adendrata.spring.tutorial.rest.common.util.Property;
import org.adendrata.spring.tutorial.rest.entity.Person;
import org.adendrata.spring.tutorial.rest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person findOne(Long id) {
        return personRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public Person create(Person person) {
        return personRepository.save(person);
    }

    public Person replace(Person person, Long id) {
        person.setId(id);
        return personRepository.save(person);
    }

    public Person patch(Person person, Long id) {
        System.out.println("123");
        Person existing = findOne(id);
        Property.copyNonNull(person, existing);

        return personRepository.save(existing);
    }

    public void delete(Long id) {
        personRepository.deleteById(id);
    }
}
