/*
package com.example.testingdemo.service;

import com.example.testingdemo.entity.Person;
import com.example.testingdemo.repository.PersonRepository;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PersonServiceUnitTestCases {
    @Mock
    PersonRepository personRepository;
    @InjectMocks
    PersonService personService;

    @AfterEach
    void afterEach(){
        Mockito.verifyNoMoreInteractions(personRepository);
    }

//    @Test
//    void givenPerson_whenAddPerson_thenReturnPerson(){
//        Person person=new Person(1L,"teja","reddy");
//        Mockito.when(personRepository.save(person)).thenReturn(person);
//        Person result=personService.addperson(person);
//        assertThat(result.getFirstName()).isEqualTo("teja");
//    }

    @Test
    void givenNothing_whenFindAll_thenReturnPersonList(){
        List<Person> personList=new ArrayList<>();
        personList.add(new Person(1L,"teja","reddy"));
        personList.add(new Person(2L,"ravi","shastri"));
        personList.add(new Person(3L,"pavan","kalyan"));
        Mockito.when(personRepository.findAll()).thenReturn(personList);
        List<Person> personList1=personService.findAllPersons();
        assertThat(personList1.size()).isEqualTo(3);
        assertThat(personList1.get(1).getFirstName()).isEqualTo("ravi");
    }

    @Test
    void givenNothing_whenDelete_thenReturnBoolean(){
        //Mockito.when(personRepository.deleteAll()).thenReturn();
//        willDoNothing().given(personRepository).deleteAll();
//        personService.deletePersons();
//        assertThat(personRepository.count()).isEqualTo(0);
//        verify(personRepository,times(1)).deleteAll();

        Mockito.doNothing().when(personRepository).deleteAll();
        personService.deletePersons();
        Mockito.verify(personRepository).deleteAll();
    }

    @Test
    void givenId_whenFindById_thenReturnPerson(){
        Person person=new Person(1L,"teja","reddy");
        Mockito.when(personRepository.findById(2L)).thenReturn(Optional.of(person));
        Person person1=personService.findPersonById(2L);
        assertThat(person1.getFirstName()).isEqualTo("teja");
    }
}
*/
