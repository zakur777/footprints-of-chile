package com.programadorescl.userpetservice.application.services.exceptions.user;

public class UserPetINotFoudException extends Exception{

    private static final long serialVersionUID = -8890080495551147845L;
    private String message;
    private Object[] args;

    public UserPetINotFoudException(String message) {
        this.message = String.format("Pet with name %s and User ID %s is not found.", message);
    }

    public UserPetINotFoudException(Object[] args) {
        this.args = args;
    }

    public UserPetINotFoudException(String message, Object[] args) {
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
