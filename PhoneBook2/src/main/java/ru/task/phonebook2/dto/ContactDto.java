package ru.task.phonebook2.dto;

import lombok.Builder;
import lombok.Data;
import ru.task.phonebook2.model.ContactType;

@Data
@Builder
public class ContactDto {
    private long id;
    private ContactType contactType;
    private String name;
    private int phoneNumber;
    private String textComments;

}
