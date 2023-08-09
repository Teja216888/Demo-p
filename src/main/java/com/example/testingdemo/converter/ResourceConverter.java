package com.example.testingdemo.converter;


import com.example.testingdemo.dto.PersonDto;
import com.example.testingdemo.entity.Person;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ResourceConverter {

    //ResourceConverter converter= Mappers.getMapper(ResourceConverter.class);

    @Mapping(source = "id",target = "id",qualifiedByName = "convertToString")
    PersonDto convertToPersonDto(Person person);
    @Mapping(source = "id",target="id",qualifiedByName = "convertToLong")
    Person convertToPersonEntity(PersonDto personDto);

    @Named("convertToString")
    public static String convertToString(Integer id){
        return String.format("D%05d",id);
    }

    @Named("convertToLong")
    public static Long convertToLong(String s){
       if(StringUtils.isNotBlank(s)){
           return Long.parseLong(s.substring(1));
       }
       else return null;
    }

}
