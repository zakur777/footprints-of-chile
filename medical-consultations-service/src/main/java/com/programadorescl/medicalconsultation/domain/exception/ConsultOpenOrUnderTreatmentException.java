package com.programadorescl.medicalconsultation.domain.exception;

public class ConsultOpenOrUnderTreatmentException extends Exception {
    private static final long serialVersionUID = -8890080495441147845L;

    private String message;
    private Object[] args;

    public ConsultOpenOrUnderTreatmentException(String name) {
        this.message = String.format("There is already a pet with the name - %s", name);
    }

    public ConsultOpenOrUnderTreatmentException(Object[] args) {
        this.args = args;
    }

    public ConsultOpenOrUnderTreatmentException(String message, Object[] args) {
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
