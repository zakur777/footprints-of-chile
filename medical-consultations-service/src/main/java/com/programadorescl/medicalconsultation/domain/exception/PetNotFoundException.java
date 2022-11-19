package com.programadorescl.medicalconsultation.domain.exception;

public class PetNotFoundException extends Exception {

    private static final long serialVersionUID = -8890080495441147845L;

    private String message;
    private Object[] args;

    public PetNotFoundException(String message) {
        this.message = String.format("Pet with %s is not found.", message);
    }

    public PetNotFoundException(Object[] args) {
        this.args = args;
    }

    public PetNotFoundException(String message, Object[] args) {
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
