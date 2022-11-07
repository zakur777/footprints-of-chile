package com.programadorescl.userpetservice.application.services.exceptions.user;

public class InvalidUserException extends Exception {

    private static final long serialVersionUID = -8890080495441147845L;

    private String message;
    private Object[] args;

    public InvalidUserException(String message) {
        this.message = String.format("%s is an invalid user.", message);
    }

    public InvalidUserException(Object[] args) {
        this.args = args;
    }

    public InvalidUserException(String message, Object[] args) {
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
