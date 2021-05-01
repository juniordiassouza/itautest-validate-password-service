package br.com.itautest.exceptions;

import br.com.itautest.exceptions.ExceptionMetadata;
import br.com.itautest.exceptions.HttpErrorException;
import br.com.itautest.exceptions.MessageExceptionEnum;

@ExceptionMetadata(
        logLevel = ExceptionMetadata.Level.INFO,
        httpStatus = 400
)
public class ValidateException extends HttpErrorException {

    public ValidateException(MessageExceptionEnum messageExceptionEnum){

        super(messageExceptionEnum.getMessage(),messageExceptionEnum.getMessage(),messageExceptionEnum.getCodigo());
    }
}
