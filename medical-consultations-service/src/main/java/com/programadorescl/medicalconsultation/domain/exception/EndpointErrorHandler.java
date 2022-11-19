package com.programadorescl.medicalconsultation.domain.exception;

import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EndpointErrorHandler {
    private static final String UNEXPECTED_ERROR = "Exception.unexpected";
    private final MessageSource messageSource;

    public EndpointErrorHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(ConsultOpenOrUnderTreatmentException.class)
    public ResponseEntity<ErrorInfo> handleDuplicatedPetException(
            HttpServletRequest request, ConsultOpenOrUnderTreatmentException ex, Locale locale) {
        ErrorInfo response = new ErrorInfo();
        response.setUrl(request.getRequestURL().toString());
        response.setMessage(messageSource.getMessage(ex.getMessage(), ex.getArgs(), locale));
        return new ResponseEntity<>(response, HttpStatus.IM_USED);
    }

    @ExceptionHandler(PethWithMedicalConsultationOpenException.class)
    public ResponseEntity<ErrorInfo> handleDuplicatedPetException(
            HttpServletRequest request,
            PethWithMedicalConsultationOpenException ex,
            Locale locale) {
        ErrorInfo response = new ErrorInfo();
        response.setUrl(request.getRequestURL().toString());
        response.setMessage(messageSource.getMessage(ex.getMessage(), ex.getArgs(), locale));
        return new ResponseEntity<>(response, HttpStatus.IM_USED);
    }

    @ExceptionHandler(PetNotFoundException.class)
    public ResponseEntity<ErrorInfo> handleDuplicatedPetException(
            HttpServletRequest request, PetNotFoundException ex, Locale locale) {
        ErrorInfo response = new ErrorInfo();
        response.setUrl(request.getRequestURL().toString());
        response.setMessage(messageSource.getMessage(ex.getMessage(), ex.getArgs(), locale));
        return new ResponseEntity<>(response, HttpStatus.IM_USED);
    }

    @ExceptionHandler(PetWithPetConsultationInCourseException.class)
    public ResponseEntity<ErrorInfo> handleDuplicatedPetException(
            HttpServletRequest request, PetWithPetConsultationInCourseException ex, Locale locale) {
        ErrorInfo response = new ErrorInfo();
        response.setUrl(request.getRequestURL().toString());
        response.setMessage(messageSource.getMessage(ex.getMessage(), ex.getArgs(), locale));
        return new ResponseEntity<>(response, HttpStatus.IM_USED);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorInfo> handleDuplicatedPetException(
            HttpServletRequest request, UserNotFoundException ex, Locale locale) {
        ErrorInfo response = new ErrorInfo();
        response.setUrl(request.getRequestURL().toString());
        response.setMessage(messageSource.getMessage(ex.getMessage(), ex.getArgs(), locale));
        return new ResponseEntity<>(response, HttpStatus.IM_USED);
    }

    @ExceptionHandler(PetConsultationNotFoundException.class)
    public ResponseEntity<ErrorInfo> handleDuplicatedPetException(
            HttpServletRequest request, PetConsultationNotFoundException ex, Locale locale) {
        ErrorInfo response = new ErrorInfo();
        response.setUrl(request.getRequestURL().toString());
        response.setMessage(messageSource.getMessage(ex.getMessage(), ex.getArgs(), locale));
        return new ResponseEntity<>(response, HttpStatus.IM_USED);
    }

    @ExceptionHandler(MedicalConsultationNotFoundException.class)
    public ResponseEntity<ErrorInfo> handleDuplicatedPetException(
            HttpServletRequest request, MedicalConsultationNotFoundException ex, Locale locale) {
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
