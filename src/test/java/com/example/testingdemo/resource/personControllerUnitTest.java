/*
package com.example.testingdemo.resource;

import com.example.testingdemo.entity.Person;
import com.example.testingdemo.resource.PersonController;
import com.example.testingdemo.service.PersonService;
import org.apache.xpath.operations.Bool;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class personControllerUnitTest {
    @InjectMocks
    private PersonController personController;
    @Mock
    private PersonService personService;

    @Mock
    private List<String> mockList=new ArrayList<>();

    @Spy
    private List<String> spyList=new ArrayList<>();

    @AfterEach
    void afterEach(){
        Mockito.verifyNoMoreInteractions(personService);
    }

    @Test
    void givenId_whenFindPerson_thenReturnPerson(){
        Mockito.when(mockList.size()).thenReturn(2);
        Mockito.when(spyList.size()).thenReturn(2);
//        mockList.add("ravi");
//        spyList.add("teja");
        assertEquals(mockList.size(),2);
        assertEquals(spyList.size(),2);

        Person person=new Person().builder()
                .firstName("teja")
                .lastName("reddy")
                .build();
        Mockito.when(personService.findPersonById(1L)).thenReturn(person);
        Person result=personController.getPersonById(1L);
        assertThat((result.getFirstName())).isEqualTo("teja");
        assertThat((result.getLastName())).isEqualTo("reddy");
        Mockito.verify(personService).findPersonById(1L);
    }

    @Test
    void givenId_whenFindPerson_thenReturnException(){
        Person person=new Person().builder()
                .firstName("teja")
                .lastName("reddy")
                .build();
        Mockito.doThrow(new NullPointerException()).when(personService).findPersonById(1L);
        assertThrows(NullPointerException.class,()->personController.getPersonById(1L));
//        Mockito.when(personService.findPersonById(1L)).thenReturn(person);
//        Person result=personController.getPersonById(1L);
//        assertThat((result.getFirstName())).isEqualTo("teja");
//        assertThat((result.getLastName())).isEqualTo("reddy");
        Mockito.verify(personService).findPersonById(1L);
    }

//    @Test
//    void givenPerson_whenAddPerson_thenReturnPerson(){
//        Person person=new Person();
//        person.setFirstName("teja");
//        person.setLastName("reddy");
//        Mockito.when(personService.addperson(person)).thenReturn(person);
//        Person result=personController.addPerson(person);
//        assertThat(result.getFirstName()).isEqualTo("teja");
//        assertThat(result.getLastName()).isEqualTo("reddy");
//    }

    @Test
    void givenNone_whenFindAll_thenReturnList(){
        Person person1=new Person().builder().firstName("ravi").lastName("shastri").build();
        Person person2=new Person().builder().firstName("teja").lastName("reddy").build();
        Person person3=new Person().builder().firstName("pavan").lastName("kalyan").build();
        List<Person> personList=new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        Mockito.when(personService.findAllPersons()).thenReturn(personList);
        List<Person> personList1=personController.findAll();
        assertThat(personList1.size()).isEqualTo(3);
        assertThat(personList1.get(1).getFirstName()).isEqualTo("teja");
        Mockito.verify(personService).findAllPersons();
    }

    @Test
    void givenNone_whenDeleteAll_thenReturnNone(){
//        Mockito.when(personService.deletePersons()).thenReturn(Boolean.TRUE);
//        Boolean result=personController.deletePersons();
//        assertThat(result).isEqualTo(true);

        Mockito.doNothing().when(personService).deletePersons();
        personController.deletePersons();
        Mockito.verify(personService).deletePersons();
    }

//    @Test
//    void givenNone_whenDeleteAll_thenReturnNone(){
//        Mockito.when(personService.deletePersons());
//        //Boolean result=personController.deletePersons();
//        //assertThat(result).isEqualTo(true);
//        assertThat(personController.deletePersons()).isEqualTo();
//    }


}
*/
