package com.programadorescl.userpetservice.application.services.exceptions.pet;

public class PetWithTreatmentException extends Exception {

    private static final long serialVersionUID = -8890080495441147845L;

    private String message;
    private Object[] args;

    public PetWithTreatmentException(String message) {
        this.message = String.format("User pets %s is with treatment.", message);
    }

    public PetWithTreatmentException(Object[] args) {
        this.args = args;
    }

    public PetWithTreatmentException(String message, Object[] args) {
        this.message = message;
        this.args = args;
    }

    @Override
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
