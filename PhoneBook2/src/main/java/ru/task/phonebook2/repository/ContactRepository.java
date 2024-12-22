package ru.task.phonebook2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.task.phonebook2.dto.ContactDto;
import ru.task.phonebook2.model.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

    @Query("select c " +
            "from Contact as c " +
            "where c.contactType = :contactType")
    List<Contact> findContactsByContactType(@Param("contactType") String contactType);

    List<ContactDto> findAllContacts();

    Optional<Contact> findContactById(long id);

}
