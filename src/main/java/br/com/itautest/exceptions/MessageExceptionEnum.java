package br.com.itautest.exceptions;

import lombok.Getter;

@Getter
public enum MessageExceptionEnum {

    MSG_ERROR_GENERIC("Request error", 500);

    private final String message;
    private final Integer code;

    MessageExceptionEnum(String message, Integer code){

        this.message=message;
        this.code = code;
    }

}
