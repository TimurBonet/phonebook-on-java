package ru.task.phonebook2.errorHandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.task.phonebook2.exception.EmptyPhoneNumberException;
import ru.task.phonebook2.exception.IncorrectTypeOfContactException;
import ru.task.phonebook2.exception.NotFoundException;
import ru.task.phonebook2.exception.OrganizationStatusException;

@RestControllerAdvice
@Slf4j
public class ErrorHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFound(NotFoundException e) {
        log.error("Возникло исключение NotFoundException . {}",e.getMessage(), e);
        return new ErrorResponse("Данные не найдены", e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleEmptyPhoneNumber(EmptyPhoneNumberException e) {
        log.error("Возникло исключение EmptyPhoneNumberException . {}",e.getMessage(), e);
        return new ErrorResponse("Телефонный номер отсутствет", e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleIncorrectTypeOfContactException(IncorrectTypeOfContactException e) {
        log.error("Возникло исключение IncorrectTypeOfContactException . {}",e.getMessage(), e);
        return new ErrorResponse("Некорректный тип контакта", e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleOrganizationStatus(OrganizationStatusException e) {
        log.error("Возникло исключение OrganizationStatusException . {}",e.getMessage(), e);
        return new ErrorResponse("Организация должна быть приватной или публичной (true/false)", e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleUnhandledException(Throwable e) {
        log.error("Возникло необработанное исключение. {}",e.getMessage(), e);
        return new ErrorResponse("Необработанное исключение", e.getMessage());
    }
}
