package org.adendrata.spring.tutorial.interceptor.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("person")
public class PersonController {

    @GetMapping
    ResponseEntity<String> get() {
        log.info("get");
        return ResponseEntity.ok("GET");
    }

    @GetMapping(value = "error")
    ResponseEntity<String> getError() {
        throw new IllegalStateException("IllegalStateException");
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> post() {
        log.info("post");
        return ResponseEntity.ok("POST");
    }


}
