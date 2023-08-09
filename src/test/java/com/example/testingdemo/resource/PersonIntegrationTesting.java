package com.example.testingdemo.resource;

import com.example.testingdemo.entity.Person;
import com.example.testingdemo.repository.PersonRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class PersonIntegrationTesting {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    MockMvc mockMvc;

    @Test
    void givenPerson_whenAddPerson_thenReturnPerson() throws Exception {
        Person person=new Person();
        person.setFirstName("teja");
        person.setLastName("reddy");
        String personJson=new ObjectMapper().writeValueAsString(person);
        mockMvc.perform(post("/person/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(personJson)).andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.firstName").exists())
                .andExpect(jsonPath("$.firstName").value("teja"))
                .andExpect(jsonPath("$.lastName").exists())
                .andExpect(jsonPath("$.lastName").value("reddy"))
                .andExpect(jsonPath("$.id").exists());
        assertThat(this.personRepository.findAll()).hasSize(1);
    }

    @Test
    void givenId_whenFindPersonById_thenReturnPerson() throws Exception {
        Person person=new Person();
        person.setFirstName("teja");
        person.setLastName("reddy");
        Person savedperson=personRepository.save(person);
        Long id= savedperson.getId();
        String url="/person/"+id;
        mockMvc.perform(get(url).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.firstName").exists())
                .andExpect(jsonPath("$.firstName").value("teja"))
                .andExpect(jsonPath("$.lastName").exists())
                .andExpect(jsonPath("$.lastName").value("reddy"))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.id").value(id));
        System.out.println("id : "+id);
    }

    @Test
    void givenNone_whenFindAll_thenReturnPersonList() throws Exception {
        List<Person> personList = new ArrayList<>();
        Person person1=new Person().builder().firstName("teja").lastName("reddy").build();
        Person person2=new Person().builder().firstName("ravi").lastName("shastri").build();
        personList.add(person1);
        personList.add(person2);
        for(Person person:personList){
            personRepository.save(person);
            System.out.println(person.getId());
        }
        MvcResult result=mockMvc.perform(get("/person").contentType(MediaType.APPLICATION_JSON)).andReturn();
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$").exists())
//                .andExpect(jsonPath("$.size()").value(personList.size()))
//                .andExpect(jsonPath("$[0].firstName").value("teja"))
//                .andExpect(jsonPath("$[1].lastName").value("shastri"));
        System.out.println(result.getResponse().getContentAsString());

    }

    @Test
    void givenNothing_whenDeleteAll_thenReturnNothing() throws Exception {
        List<Person> personList = new ArrayList<>();
        Person person1=new Person().builder().firstName("teja").lastName("reddy").build();
        Person person2=new Person().builder().firstName("ravi").lastName("shastri").build();
        personList.add(person1);
        personList.add(person2);
        for(Person person:personList){
            personRepository.save(person);
            System.out.println(person.getId());
        }
        mockMvc.perform(delete("/person/delete"))
                .andExpect(status().isOk());

        assertThat(this.personRepository.findAll()).hasSize(0);



    }
}
