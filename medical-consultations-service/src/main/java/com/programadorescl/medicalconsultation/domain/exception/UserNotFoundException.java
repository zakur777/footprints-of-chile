package com.programadorescl.medicalconsultation.domain.exception;

public class UserNotFoundException extends Exception {

    private static final long serialVersionUID = -8890080495441147845L;

    private String message;
    private Object[] args;

    public UserNotFoundException(String message) {
        this.message = String.format("User with %s is not found.", message);
    }

    public UserNotFoundException(Object[] args) {
        this.args = args;
    }

    public UserNotFoundException(String message, Object[] args) {
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
