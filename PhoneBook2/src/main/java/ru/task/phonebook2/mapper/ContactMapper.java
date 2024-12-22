package ru.task.phonebook2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.task.phonebook2.dto.ContactDto;
import ru.task.phonebook2.model.Contact;

@Mapper
public interface ContactMapper {
    ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);

    @Mapping(target = "id", source = "entity.id")
    @Mapping(target = "name", source = "entity.name")
    @Mapping(target = "phoneNumber", source = "entity.phoneNumber")
    @Mapping(target = "textComments", source = "entity.textComments")
    ContactDto entityToDto(Contact entity);

    @Mapping(target = "id", source = "dto.id")
    @Mapping(target = "name", source = "dto.name")
    @Mapping(target = "phoneNumber", source = "dto.phoneNumber")
    @Mapping(target = "textComments", source = "dto.textComments")
    Contact dtoToEntity(ContactDto dto);
}
