package ru.task.phonebook2.exception;

public class EmptyPhoneNumberException extends RuntimeException {
    public EmptyPhoneNumberException(final String message) {
        super(message);
    }
}
