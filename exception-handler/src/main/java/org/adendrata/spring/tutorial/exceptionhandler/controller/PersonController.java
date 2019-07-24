package org.adendrata.spring.tutorial.exceptionhandler.controller;

import lombok.extern.slf4j.Slf4j;
import org.adendrata.spring.tutorial.exceptionhandler.dto.PersonDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("person")
public class PersonController {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PersonDTO> post(@RequestBody @Validated PersonDTO personDTO) {
        log.info("firstName : " + personDTO.getFirstName());
        log.info("lastName : " + personDTO.getLastName());
        log.info("height" + personDTO.getHeight());

        return ResponseEntity.ok(personDTO);
    }


}
