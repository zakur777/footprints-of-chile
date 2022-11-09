package com.programadorescl.medicalconsultation.domain.exception;

public class MedicalConsultationNotFoundException extends Exception{

    private static final long serialVersionUID = -8890080495441147845L;

    private String message;
    private Object[] args;

    public MedicalConsultationNotFoundException(String message){
        this.message = String.format("Booking %s is not found.", message);
    }

    public MedicalConsultationNotFoundException(Object[] args) {
        this.args = args;
    }

    public MedicalConsultationNotFoundException(String message, Object[] args){
        this.message = message;
        this.args = args;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
