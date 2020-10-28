package com.example.restapi.restexceptionhandler;

import com.example.restapi.exception.UserNotFoundException;
import com.example.restapi.exception.UserNotFoundExceptionDetails;
import com.example.restapi.exception.UserNotValidatedDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@SuppressWarnings({"unchecked","rawtypes"})
@Slf4j
public class RestHandler {

       @ExceptionHandler(UserNotFoundException.class)
       public ResponseEntity<UserNotFoundExceptionDetails> handleResourceNotFoundException (UserNotFoundException e){

           return new ResponseEntity<>(
                   UserNotFoundExceptionDetails.builder()
                           .timestamp(LocalDateTime.now())
                           .status(HttpStatus.NOT_FOUND.value())
                           .title("Resource not Found")
                           .detail(e.getMessage())
                           .developerMessage(e.getClass().getName())
                           .build(), HttpStatus.NOT_FOUND);






       }
    //listen to this method
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<UserNotValidatedDetails> handleUserNotFoundException(MethodArgumentNotValidException e){
              List<FieldError> fielderrors = e.getBindingResult().getFieldErrors();
        String fields = fielderrors .stream().map(FieldError::getField).collect(Collectors.joining(", "));
        String fieldsMessage = fielderrors .stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));
        return new ResponseEntity<>(
                UserNotValidatedDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Field Validation Error")
                        .detail("Check the field(s) below")
                        .developerMessage(e.getClass().getName())
                        .fields(fields)
                        .fieldsMessage(fieldsMessage)
                        .build(), HttpStatus.BAD_REQUEST);
    }


}
