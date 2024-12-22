package ru.task.phonebook2.exception;

public class OrganizationStatusException extends RuntimeException {
    public OrganizationStatusException(final String message) {
        super(message);
    }
}
