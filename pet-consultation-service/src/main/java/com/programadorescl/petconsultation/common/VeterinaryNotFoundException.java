package com.programadorescl.petconsultation.common;

public class VeterinaryNotFoundException extends Exception {

    private static final long serialVersionUID = -8890080495441147845L;

    private String message;
    private Object[] args;

    public VeterinaryNotFoundException(String message) {
        this.message = String.format("Booking %s is not found.", message);
    }

    public VeterinaryNotFoundException(Object[] args) {
        this.args = args;
    }

    public VeterinaryNotFoundException(String message, Object[] args) {
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
