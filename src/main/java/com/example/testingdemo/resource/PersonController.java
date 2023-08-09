package com.example.testingdemo.resource;

import com.example.testingdemo.dto.PersonDto;
import com.example.testingdemo.entity.Person;
import com.example.testingdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.OptionalDouble;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping
    public List<PersonDto> findAll(){
        return personService.findAllPersons();
    }

    @PostMapping("/add")
    //@RequestMapping(value = "/add",method = RequestMethod.POST)
    public PersonDto addPerson(@RequestBody PersonDto personDto){
        return personService.addperson(personDto);
        //return "person added successfully";
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id){
       // if(id==1L)throw new NullPointerException("one is not allowed");
        return personService.findPersonById(id);
    }


    @DeleteMapping("/delete")
    public void deletePersons(){
        personService.deletePersons();
    }
}
