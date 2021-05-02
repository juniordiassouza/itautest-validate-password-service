package br.com.itautest.exceptions;

@ExceptionMetadata(
        logLevel = ExceptionMetadata.Level.INFO,
        httpStatus = 400
)
public class ValidateException extends HttpErrorException {

    public ValidateException(MessageExceptionEnum messageExceptionEnum){

        super(messageExceptionEnum.getMessage(),messageExceptionEnum.getMessage(),messageExceptionEnum.getCode());
    }
}
