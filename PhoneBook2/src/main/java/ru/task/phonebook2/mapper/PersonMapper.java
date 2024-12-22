package ru.task.phonebook2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.task.phonebook2.dto.PersonDto;
import ru.task.phonebook2.model.Person;

@Mapper(uses = {ContactMapper.class})
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "id", source = "entity.id")
    @Mapping(target = "name", source = "entity.name")
    @Mapping(target = "phoneNumber", source = "entity.phoneNumber")
    @Mapping(target = "textComments", source = "entity.textComments")
    @Mapping(target = "email", source = "entity.email")
    PersonDto personToDto(Person entity);

    @Mapping(target = "id", source = "dto.id")
    @Mapping(target = "name", source = "dto.name")
    @Mapping(target = "phoneNumber", source = "dto.phoneNumber")
    @Mapping(target = "textComments", source = "dto.textComments")
    @Mapping(target = "email", source = "dto.email")
    Person dtoToPerson(PersonDto dto);
}
