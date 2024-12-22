package ru.task.phonebook2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.*;

@Entity
@Table(name = "contacts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "contactType")
    @Enumerated(EnumType.STRING)
    private ContactType contactType;

    @Column(name = "name")
    @NotBlank
    private String name;

    @Column(name = "phoneNumber")
    private int phoneNumber;

    @Column(name = "textComments")
    private String textComments;


}
