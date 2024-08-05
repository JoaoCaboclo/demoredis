package com.example.demoredis.controller;

import com.example.demoredis.model.Person;
import com.example.demoredis.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/all")
    public List<Person> getPerson() {
        return (List<Person>) personRepository.findAll();
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }


    @GetMapping("/{id}")
    public Person getPerson(@PathVariable String id) {
        return personRepository.findById(id).orElse(null);
    }
}
