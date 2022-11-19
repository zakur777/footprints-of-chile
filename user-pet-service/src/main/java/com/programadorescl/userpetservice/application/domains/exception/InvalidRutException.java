package com.programadorescl.userpetservice.application.domains.exception;

public class InvalidRutException extends Exception {

    private static final long serialVersionUID = -8890080495441147845L;

    private String message;
    private Object[] args;

    public InvalidRutException(String message) {
        this.message = String.format("Thge rut - %s is not valid", message);
    }

    public InvalidRutException(Object[] args) {
        this.args = args;
    }

    public InvalidRutException(String message, Object[] args) {
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
