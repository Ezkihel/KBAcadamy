package com.example.restapi.exception;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class UserNotValidatedDetails extends CommonExceptionDetails{
    private String fields;
    private String fieldsMessage;
}
