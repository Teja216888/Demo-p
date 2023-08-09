package com.example.testingdemo.service;

import com.example.testingdemo.converter.ResourceConverter;
import com.example.testingdemo.dto.PersonDto;
import com.example.testingdemo.entity.Person;
import com.example.testingdemo.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PersonService {

    private ResourceConverter resourceConverter;
    private PersonRepository personRepository;
    public Person findPersonById(Long id){
        return personRepository.findById(id).get();
    }

    public PersonDto addperson(PersonDto personDto){
        Person person=resourceConverter.convertToPersonEntity(personDto);
        return resourceConverter.convertToPersonDto(personRepository.save(person));
    }

    public void deletePersons(){
        personRepository.deleteAll();
    }

    public List<PersonDto> findAllPersons(){
        List<PersonDto> personList=new ArrayList<>();
        personRepository.findAll().forEach(i->personList.add(resourceConverter.convertToPersonDto(i)));
        return personList;
    }
}
