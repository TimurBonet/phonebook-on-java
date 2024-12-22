package ru.task.phonebook2.service;

import ru.task.phonebook2.dto.ContactDto;
import ru.task.phonebook2.dto.ContactOrganizationDto;
import ru.task.phonebook2.dto.PersonDto;
import ru.task.phonebook2.model.Contact;
import ru.task.phonebook2.model.ContactType;

import java.util.List;

public interface ContactService {
    PersonDto createContactPerson(PersonDto personDto);

    ContactOrganizationDto createContactOrganization(ContactOrganizationDto contactOrganizationDto);

    PersonDto updateContactPerson(PersonDto personDto, long id);

    ContactOrganizationDto updateContactOrganization(ContactOrganizationDto contactOrganizationDto, long id);

    PersonDto getPersonById(long id);

    ContactOrganizationDto getOrganizationById(long id);

    ContactDto getContactById(long id);

    List<ContactDto> findAllContacts();

    List<Contact> findContactsByContactType(ContactType contactType);
}
