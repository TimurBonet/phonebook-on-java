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
public class Organization extends Contact{

    @Column(name = "isPrivate")
    private Boolean isPrivate;

    @Column(name = "city")
    private String city;

    @Column(name = "url")
    private String url;
}

