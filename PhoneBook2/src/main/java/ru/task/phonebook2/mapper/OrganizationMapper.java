package ru.task.phonebook2.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import ru.task.phonebook2.dto.ContactOrganizationDto;
import ru.task.phonebook2.dto.PersonDto;
import ru.task.phonebook2.model.Organization;
import ru.task.phonebook2.model.Person;

@Mapper(uses = {ContactMapper.class})
public interface OrganizationMapper {

    OrganizationMapper INSTANCE = Mappers.getMapper(OrganizationMapper.class);

    @Mapping(target = "id", source = "entity.id")
    @Mapping(target = "name", source = "entity.name")
    @Mapping(target = "phoneNumber", source = "entity.phoneNumber")
    @Mapping(target = "textComments", source = "entity.textComments")
    @Mapping(target = "isPrivate", source = "entity.isPrivate")
    @Mapping(target = "city", source = "entity.city", qualifiedByName = "isPrivateOrganization")
    @Mapping(target = "url", source = "entity.url")
    ContactOrganizationDto  organizationToDto(Organization entity);

    @Mapping(target = "id", source = "dto.id")
    @Mapping(target = "name", source = "dto.name")
    @Mapping(target = "phoneNumber", source = "dto.phoneNumber")
    @Mapping(target = "textComments", source = "dto.textComments")
    @Mapping(target = "isPrivate", source = "entity.isPrivate")
    @Mapping(target = "city", source = "entity.city"/*, qualifiedByName = "isPrivateOrganization"*/)
    @Mapping(target = "url", source = "entity.url")
    Organization dtoToOrganization (ContactOrganizationDto dto);

    @Named("isPrivateOrganization")
    @Condition
    default boolean isPrivateOrganization(@Context Organization organization) {
        return organization.getIsPrivate();
    }
}