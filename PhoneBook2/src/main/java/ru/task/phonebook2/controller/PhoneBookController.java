package ru.task.phonebook2.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.task.phonebook2.dto.ContactDto;
import ru.task.phonebook2.exception.IncorrectTypeOfContactException;
import ru.task.phonebook2.model.ContactType;
import ru.task.phonebook2.service.ContactService;

@Slf4j
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping(path = "/phonebook2")
public class PhoneBookController {
    private final ContactService contactService;

    @GetMapping("/{contactId}")
    public void getContactById(@PathVariable int contactId,
                           @RequestBody @Valid ContactDto contactDto) {
        if(contactDto.getContactType().name().equals(ContactType.PERSON.name())){
            log.info("Get person by id {}", contactId);
            contactService.getPersonById(contactId);
        } else if(contactDto.getContactType().equals(ContactType.ORGANISATION)){
            log.info("Get organization by id {}", contactId);
            contactService.getOrganizationById(contactId);
        } else {
            throw new IncorrectTypeOfContactException("Invalid contact type");
        }
    }

    @GetMapping
    public void getContactByType (@RequestBody @Valid ContactDto contactDto) {
        if(contactDto.getContactType().equals(ContactType.PERSON)){
            log.info("Get person by type {}", contactDto.getContactType());
            contactService.findContactsByContactType(contactDto.getContactType());
        } else if(contactDto.getContactType().equals(ContactType.ORGANISATION)){
            log.info("Get organization by type {}", contactDto.getContactType());
            contactService.findContactsByContactType(contactDto.getContactType());
        } else {
            throw new IncorrectTypeOfContactException("Invalid contact type");
        }
    }
}
