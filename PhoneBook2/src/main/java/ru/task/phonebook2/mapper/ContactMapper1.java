/*
package ru.task.phonebook2.mapper;

import lombok.experimental.UtilityClass;
import ru.task.phonebook2.dto.ContactDto;
import ru.task.phonebook2.dto.ContactOrganizationDto;
import ru.task.phonebook2.dto.PersonDto;
import ru.task.phonebook2.model.Contact;
import ru.task.phonebook2.model.Person;

//@Mapper(componentModel = "spring")
//@Slf4j
@UtilityClass
public class ContactMapper1 {
    public Person personDtoToPerson(PersonDto personDto) {
        return Person.builder()
                .id(personDto.getId())
                .name(personDto.getName())
                .contactType(personDto.getContactType())
                .phoneNumber(personDto.getPhoneNumber())
                .textComments(personDto.getTextComments())
                .email(personDto.getEmail())
                .build();
    }

    public Contact personDtoToContact(PersonDto personDto) {
        return Contact.builder()
                .id(personDto.getId())
                .name(personDto.getName())
                .contactType(personDto.getContactType())
                .phoneNumber(personDto.getPhoneNumber())
                .textComments(personDto.getTextComments())
                .email(personDto.getEmail())
                .isPrivate(null)
                .url(null)
                .build();
    }

    public PersonDto contactToPersonDto(Contact contact) {
        return PersonDto.builder()
                .id(contact.getId())
                .name(contact.getName())
                .contactType(contact.getContactType())
                .phoneNumber(contact.getPhoneNumber())
                .textComments(contact.getTextComments())
                .email(contact.getEmail())
                .build();
    }

    public Contact contactOrganizationDtoToContact(ContactOrganizationDto contactOrganizationDto) {
         return Contact.builder()
                .id(contactOrganizationDto.getId())
                .name(contactOrganizationDto.getName())
                .contactType(contactOrganizationDto.getContactType())
                .phoneNumber(contactOrganizationDto.getPhoneNumber())
                .textComments(contactOrganizationDto.getTextComments())
                .email(null)
                .isPrivate(contactOrganizationDto.getIsPrivate())
                .url(contactOrganizationDto.getUrl())
                .build();
    }

    public ContactOrganizationDto contactToContactOrganizationDto(Contact contact) {
        return ContactOrganizationDto.builder()
                .id(contact.getId())
                .name(contact.getName())
                .contactType(contact.getContactType())
                .phoneNumber(contact.getPhoneNumber())
                .textComments(contact.getTextComments())
                .isPrivate(contact.getIsPrivate())
                .url(contact.getUrl())
                .build();
    }

    public Contact contactDtoToContact(ContactDto contactDto){
        return Contact.builder()
                .id(contactDto.getId())
                .name(contactDto.getName())
                .contactType(contactDto.getContactType())
                .phoneNumber(contactDto.getPhoneNumber())
                .textComments(contactDto.getTextComments())
                .email(contactDto.getEmail())
                .isPrivate(contactDto.getIsPrivate())
                .url(contactDto.getUrl())
                .build();
    }

    public ContactDto contactToContactDto(Contact contact){
        return ContactDto.builder()
                .id(contact.getId())
                .name(contact.getName())
                .contactType(contact.getContactType())
                .phoneNumber(contact.getPhoneNumber())
                .textComments(contact.getTextComments())
                .email(contact.getEmail())
                .isPrivate(contact.getIsPrivate())
                .url(contact.getUrl())
                .build();
    }
}
*/
