package com.programadorescl.userpetservice.application.domains.valueobjects.user;

import com.programadorescl.userpetservice.application.domains.exception.InvalidRutException;

public class Rut {

    private final String value;

    public Rut(String value) throws InvalidRutException {
        if (!validarRut(value)) {
            Object[] args = {value};
            throw new InvalidRutException("invalidRut", args);
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private boolean validarRut(String rut) {

        boolean validacion = false;
        try {
            rut =  rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
