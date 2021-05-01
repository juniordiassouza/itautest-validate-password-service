package br.com.itautest.exceptions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Target({ElementType.TYPE})
public @interface ExceptionMetadata {
    ExceptionMetadata.Level logLevel() default ExceptionMetadata.Level.ERROR;

    int httpStatus() default 500;

    boolean defaultMessageTemplate() default true;

    public static enum Level {
        OFF,
        ERROR,
        WARN,
        INFO,
        DEBUG,
        TRACE;

        private Level() {
        }
    }
}
