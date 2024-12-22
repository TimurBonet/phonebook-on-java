package ru.task.phonebook2.exception;

public class IncorrectTypeOfContactException extends RuntimeException {
    public IncorrectTypeOfContactException(final String message) {
        super(message);
    }
}
