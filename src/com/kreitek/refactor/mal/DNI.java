package com.kreitek.refactor.mal;

import java.util.Date;

public class DNI {

    public static TIPODNI enumTipo;    // tipo de documento
    public static String numeroDNI;
    public static Date fechaValidez;

    private Validator dni;
    private Validator cif;
    private Validator nie;

    public DNI(TIPODNI tipo, String numeroDNI, Date fechaValidez) {
        enumTipo = tipo;
        DNI.numeroDNI = numeroDNI;
        DNI.fechaValidez = fechaValidez;

        dni = new DNIValidator();
        cif = new CIFValidator();
        nie = new NIEValidator();
    }


    public boolean validarDNI() {
        return dni.validator();
    }

    public boolean validarCIF() {
        return cif.validator();
    }

    public boolean validarNIE() {
        return nie.validator();
    }

}
