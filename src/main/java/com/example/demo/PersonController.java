package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@RestController
public class PersonController {

    private AtomicLong atomicLong = new AtomicLong();
    @GetMapping("/people")
    ResponseEntity getPeople(@RequestParam List<String> names) {
        if (names.size() == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (names.stream().anyMatch(name -> !name.contains(" "))) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<Person> collect = names.stream().map(String::toUpperCase)
                .map(name -> name.replace(" ", ","))
                .sorted()
                .map(name -> new Person(atomicLong.incrementAndGet(), name))
                .collect(Collectors.toList());
        return new ResponseEntity<>(collect, HttpStatus.OK);
    }
}
