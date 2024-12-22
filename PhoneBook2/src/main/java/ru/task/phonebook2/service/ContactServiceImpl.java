package ru.task.phonebook2.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.task.phonebook2.dto.ContactDto;
import ru.task.phonebook2.dto.ContactOrganizationDto;
import ru.task.phonebook2.dto.PersonDto;
import ru.task.phonebook2.exception.EmptyPhoneNumberException;
import ru.task.phonebook2.exception.IncorrectTypeOfContactException;
import ru.task.phonebook2.exception.NotFoundException;
import ru.task.phonebook2.exception.OrganizationStatusException;
import ru.task.phonebook2.mapper.OrganizationMapper;
import ru.task.phonebook2.mapper.PersonMapper;
import ru.task.phonebook2.model.Contact;
import ru.task.phonebook2.model.ContactType;
import ru.task.phonebook2.model.Organization;
import ru.task.phonebook2.model.Person;
import ru.task.phonebook2.repository.ContactRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;
    //private final ContactMapper contactMapper;
    //ContactMapper contactMapper;

    @Override
    public PersonDto createContactPerson(PersonDto personDto) {
        log.info("Create Contact Person {}", personDto);
        Contact person = contactRepository.save(PersonMapper.INSTANCE.dtoToPerson(personDto));
        log.info("Contact Person {} created", person);
        return /*contactMapper.*/PersonMapper.INSTANCE.personToDto((Person) person);
    }

    @Override
    public ContactOrganizationDto createContactOrganization(ContactOrganizationDto contactOrganizationDto) {
        log.info("Create Contact Organization {}", contactOrganizationDto);
        Contact organization = contactRepository.save(OrganizationMapper.INSTANCE.dtoToOrganization(contactOrganizationDto));
        log.info("Contact Organization {} created", organization);
        return OrganizationMapper.INSTANCE.organizationToDto((Organization) organization);
    }

    @Override
    public PersonDto updateContactPerson(PersonDto personDto, long id) {
        log.info("Update Contact Person {}", personDto);
        
        Contact person = contactRepository.save(PersonMapper.INSTANCE.dtoToPerson(getPersonById(id)));
        return PersonMapper.INSTANCE.personToDto((Person) person);
    }
    
    private void checkPersonDto (PersonDto personDto) {
        if (personDto == null) {
            throw new NullPointerException("Отсутствует запись");
        }
        if (personDto.getName().isEmpty()) {
            throw new NullPointerException("Имя не может быть пустым");
        }
        if (personDto.getEmail().isBlank()) {
            throw new
        }
    }

    @Override
    public ContactOrganizationDto updateContactOrganization(ContactOrganizationDto contactOrganizationDto, long id) {
        return null;
    }

    @Override
    public PersonDto getPersonById(long id) {
        Contact contact = contactRepository.findContactById(id).orElseThrow(() ->
                new NotFoundException("Нет контакта с таким Id: " + id));
        log.info("Контакт найден:  {}", contact);
        return PersonMapper.INSTANCE.personToDto((Person) contact);
    }

    @Override
    public ContactOrganizationDto getOrganizationById(long id) {
        return null;
    }

    @Override
    public ContactDto getContactById(long id) {
        return null;
    }

    @Override
    public List<ContactDto> findAllContacts() {
        return List.of();
    }

    @Override
    public List<Contact> findContactsByContactType(ContactType contactType) {
        return List.of();
    }


/*

    @Override
    public ContactOrganizationDto createContactOrganization(ContactOrganizationDto contactOrganizationDto) {
        log.info("Create Contact Organization {}", contactOrganizationDto);
        Contact organization = contactRepository.save(*/
/*contactMapper.*//*
contactOrganizationDtoToContact(contactOrganizationDto));
        log.info("Contact Organization {} created", organization);
        return */
/*contactMapper.*//*
contactToContactOrganizationDto(organization);
    }

    @Override
    public PersonDto updateContactPerson(PersonDto newPerson, long id) { //должно измениться в зависимости от типа ContactType
        log.info("Update Contact {}", newPerson);
        Contact updatedContact = contactRepository.findContactById(id)
                .orElseThrow(() -> new NotFoundException("Contact not found"));
        if (newPerson.getContactType() != null && newPerson.getContactType().equals(ContactType.ORGANISATION)) {
            throw new IncorrectTypeOfContactException("Incorrect type of contact, contact type must be Person");
        }
        if (newPerson.getName() != null && !newPerson.getName().isBlank()) {
            updatedContact.setName(newPerson.getName());
        }
        if (newPerson.getPhoneNumber() != 0) {
            updatedContact.setPhoneNumber(newPerson.getPhoneNumber());
        } else {
            throw new EmptyPhoneNumberException("Empty phone number");
        }
        updatedContact.setTextComments(newPerson.getTextComments());
        updatedContact.setEmail(newPerson.getEmail());
        log.info("Person id:{} updated : {}", id, updatedContact);
        return */
/*contactMapper.*//*
contactToPersonDto(updatedContact);
    }

    @Override
    public ContactOrganizationDto updateContactOrganization(ContactOrganizationDto newOrganization, long id) {
        log.info("Update Contact {}", newOrganization);
        Contact updatedContact = contactRepository.findContactById(id)
                .orElseThrow(() -> new NotFoundException("Contact not found"));
        if (newOrganization.getContactType() != null && newOrganization.getContactType().equals(ContactType.ORGANISATION)) {
            throw new IncorrectTypeOfContactException("Incorrect type of contact, contact type must be Person");
        }
        if (newOrganization.getName() != null && !newOrganization.getName().isBlank()) {
            updatedContact.setName(newOrganization.getName());
        }
        if (newOrganization.getPhoneNumber() != 0) {
            updatedContact.setPhoneNumber(newOrganization.getPhoneNumber());
        } else {
            throw new EmptyPhoneNumberException("Empty phone number");
        }
        updatedContact.setTextComments(newOrganization.getTextComments());
        if(newOrganization.getIsPrivate() != null ) {
            updatedContact.setIsPrivate(newOrganization.getIsPrivate());
        } else {
            throw new OrganizationStatusException("Organization must be private, or public");
        }
        updatedContact.setUrl(newOrganization.getUrl());
        log.info("Organization id:{} updated : {}", id, updatedContact);
        return */
/*contactMapper.*//*
contactToContactOrganizationDto(updatedContact);

    }

    @Override
    public PersonDto getPersonById(long id){
        log.info("Get Contact Person by id {}", id);
        Contact contact = contactRepository.findContactById(id)
            .orElseThrow(() -> new NotFoundException("Contact with id: "+ id + "not found"));

        log.info("Successful get contact person id:{} : {}", id, contact);
        return */
/*contactMapper.*//*
contactToPersonDto(contact);
    }

    @Override
    public ContactOrganizationDto getOrganizationById(long id){
        log.info("Get Contact Organization by id {}", id);
        Contact contact = contactRepository.findContactById(id)
            .orElseThrow(() -> new NotFoundException("Contact with id: "+ id + "not found"));

        log.info("Successful get contact organization id:{} : {}", id, contact);
        return */
/*contactMapper.*//*
contactToContactOrganizationDto(contact);
    }

    @Override
    public ContactDto getContactById(long id){
        log.info("Get Contact by id {}", id);
        Contact contact = contactRepository.findContactById(id)
                .orElseThrow(() -> new NotFoundException("Contact with id: "+ id + "not found"));

        log.info("Successful get contact id:{} : {}", id, contact);
        return */
/*contactMapper.*//*
contactToContactDto(contact);
    }

    @Override
    public List<ContactDto> findAllContacts() {
        log.info("Find All Contacts");
        List<ContactDto> contacts = contactRepository.findAll()
                .stream()
                .map(c -> */
/*contactMapper.*//*
contactToContactDto(c))
                .collect(Collectors.toList());
        log.info("Successful find all {} contacts", contacts.size());
        return contacts;
    }

    @Override
    public List<Contact> findContactsByContactType(ContactType contactType) {
        log.info("Find Contact by type {}", contactType);
        List<Contact> contacts;
        switch (contactType) {
            case PERSON ->
                contacts = contactRepository.findContactsByContactType(ContactType.PERSON.name());

            case ORGANISATION ->
                contacts = contactRepository.findContactsByContactType(ContactType.ORGANISATION.name());
            case null, default -> contacts = new ArrayList<>();
        }
        log.info("Successful find all {} contacts with type - {}", contacts.size(), contactType);
        return contacts;
    }
*/

}
