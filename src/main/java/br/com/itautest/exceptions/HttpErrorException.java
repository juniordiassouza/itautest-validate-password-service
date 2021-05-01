package br.com.itautest.exceptions;

import org.slf4j.LoggerFactory;

@ExceptionMetadata(
        logLevel = ExceptionMetadata.Level.ERROR,
        httpStatus = 500
)
public class HttpErrorException extends RuntimeException {
    private String message;
    private Integer codigo;
    public HttpErrorException(String message, String messageDetail, Integer codigo) {
        this(message, messageDetail, codigo, (Throwable)null);
    }

    public HttpErrorException(String message, String messageDetail, Integer codigo, Throwable cause) {
        super(message, cause);
        this.message = messageDetail;
        this.codigo = codigo;
        LoggerFactory.getLogger(this.getClass()).debug(message);
    }
}