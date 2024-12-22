package ru.task.phonebook2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person extends Contact{

    @Column(name = "Email")
    private String email;
}

