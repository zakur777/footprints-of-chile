package com.programadorescl.petconsultation.common;

public class DuplicatePetConsultationException extends Exception {

    private static final long serialVersionUID = -8890080495441147845L;

    private String message;
    private Object[] args;

    public DuplicatePetConsultationException(String message){
        this.message = String.format("Booking %s is not found.", message);
    }

    public DuplicatePetConsultationException(Object[] args) {
        this.args = args;
    }

    public DuplicatePetConsultationException(String message, Object[] args){
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
