package br.com.itautest.exceptions;

import lombok.Getter;

@Getter
public enum MessageExceptionEnum {

    MSG_ERROR_GENERIC("Request error", 500);

    private final String message;
    private final Integer codigo;

    MessageExceptionEnum(String message, Integer codigo){

        this.message=message;
        this.codigo=codigo;
    }

}
