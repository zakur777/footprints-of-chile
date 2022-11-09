package com.programadorescl.userpetservice.application.services.exceptions.pet;

public class DuplicatePetException extends Exception{

    private static final long serialVersionUID = -8890080495441147845L;

    private String message;
    private Object[] args;

    public DuplicatePetException(String message) {
        this.message = String.format("There is already a pet with the id - %s", message);
    }

    public DuplicatePetException(Object[] args) {
        this.args = args;
    }

    public DuplicatePetException(String message, Object[] args) {
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
