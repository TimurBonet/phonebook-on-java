package ru.task.phonebook2.errorHandler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorResponse {
    private final String error;
    private final String message;
}
