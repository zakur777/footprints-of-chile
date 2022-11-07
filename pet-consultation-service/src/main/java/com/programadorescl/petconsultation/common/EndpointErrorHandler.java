package com.programadorescl.petconsultation.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@ControllerAdvice
public class EndpointErrorHandler {

    private static final String UNEXPECTED_ERROR = "Exception.unexpected";
    private final MessageSource messageSource;

    @Autowired
    public EndpointErrorHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(VeterinaryNotFoundException.class)
    public ResponseEntity<ErrorInfo> handleVeterinaryNotFoundException(HttpServletRequest request,
                                                                       VeterinaryNotFoundException ex, Locale locale) {
        ErrorInfo response = new ErrorInfo();
        response.setUrl(request.getRequestURL().toString());
        response.setMessage(messageSource.getMessage(ex.getMessage(), ex.getArgs(), locale));
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateVeterinaryException.class)
    public ResponseEntity<ErrorInfo> handleDuplicateVeterinaryException(HttpServletRequest request,
                                                                        DuplicateVeterinaryException ex, Locale locale) {
        ErrorInfo response = new ErrorInfo();
        response.setUrl(request.getRequestURL().toString());
        response.setMessage(messageSource.getMessage(ex.getMessage(), ex.getArgs(), locale));
        return new ResponseEntity<>(response, HttpStatus.IM_USED);
    }

    @ExceptionHandler(PetConsultationNotFoundException.class)
    public ResponseEntity<ErrorInfo> handlePetConsultationNotFoundException(HttpServletRequest request,
                                                                       PetConsultationNotFoundException ex, Locale locale) {
        ErrorInfo response = new ErrorInfo();
        response.setUrl(request.getRequestURL().toString());
        response.setMessage(messageSource.getMessage(ex.getMessage(), ex.getArgs(), locale));
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicatePetConsultationException.class)
    public ResponseEntity<ErrorInfo> handleDuplicatePetConsultationException(HttpServletRequest request,
                                                                        DuplicatePetConsultationException ex, Locale locale) {
        ErrorInfo response = new ErrorInfo();
        response.setUrl(request.getRequestURL().toString());
        response.setMessage(messageSource.getMessage(ex.getMessage(), ex.getArgs(), locale));
        return new ResponseEntity<>(response, HttpStatus.IM_USED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorInfo> handleException(Exception ex, Locale locale) {
        String errorMessage = messageSource.getMessage(UNEXPECTED_ERROR, null, locale);
        return new ResponseEntity<>(new ErrorInfo(errorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
