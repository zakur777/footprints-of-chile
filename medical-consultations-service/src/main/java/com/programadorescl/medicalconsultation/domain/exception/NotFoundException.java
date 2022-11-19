package com.programadorescl.medicalconsultation.domain.exception;

import java.io.IOException;

public class NotFoundException extends IOException {
    private static final long serialVersionUID = -8890080495441147845L;

    private String message;
    private Object[] args;

    public NotFoundException() {}

    public NotFoundException(String name) {
        this.message = String.format("not found", name);
    }

    public NotFoundException(Object[] args) {
        this.args = args;
    }

    public NotFoundException(String message, Object[] args) {
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
