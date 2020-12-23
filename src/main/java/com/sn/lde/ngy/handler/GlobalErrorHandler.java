package com.sn.lde.ngy.handler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleException(Exception ex, HttpServletRequest  httpServletRequest){
        Error error = new Error(ex.getMessage(), ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    static class Error{
        private String message;
        private String cause;
        private LocalDateTime exceptionTime;

        public Error() {
        }

        public Error(String message, String cause, LocalDateTime exceptionTime) {
            this.message = message;
            this.cause = cause;
            this.exceptionTime = exceptionTime;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getCause() {
            return cause;
        }

        public void setCause(String cause) {
            this.cause = cause;
        }

        public LocalDateTime getExceptionTime() {
            return exceptionTime;
        }

        public void setExceptionTime(LocalDateTime exceptionTime) {
            this.exceptionTime = exceptionTime;
        }
    }
}
