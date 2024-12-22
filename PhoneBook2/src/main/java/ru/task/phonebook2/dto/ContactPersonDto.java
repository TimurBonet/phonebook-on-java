package ru.task.phonebook2.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonDto extends ContactDto {
    private String email;
}
