package org.adendrata.spring.tutorial.rest.repository;

import org.adendrata.spring.tutorial.rest.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
