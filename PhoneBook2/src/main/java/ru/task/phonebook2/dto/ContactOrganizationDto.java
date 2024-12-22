package ru.task.phonebook2.dto;

import lombok.Builder;
import lombok.Data;
import ru.task.phonebook2.model.ContactType;

@Data
@Builder
public class ContactOrganizationDto {
    private long id;
    private ContactType contactType; //= ContactType.ORGANISATION;
    private String name;
    private int phoneNumber;
    private String textComments;
    private Boolean isPrivate;
    private String city;
    private String url;


}
