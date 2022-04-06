package com.kreitek.refactor.mal;

class  Main
{
    public static void main(String args[])
    {
        System.out.println("=====================");
        System.out.println("Vamos a refactorizar!");
        System.out.println("=====================");

        DNI dniCorrecto = new DNI(TIPODNI.DNI, "11111111H", null);
        Boolean esValido = (dniCorrecto.validarDNI() == true);
        System.out.println( "DNI " + dniCorrecto.numeroDNI + " es: " + esValido.toString());

        DNI dniIncorrecto01 = new DNI(TIPODNI.DNI, "24324356A", null);
        Boolean esValido01 = (dniIncorrecto01.validarDNI() == true);
        System.out.println( "DNI " + dniIncorrecto01.numeroDNI + " es: " + esValido01.toString());

        DNI nieCorrecto = new DNI(TIPODNI.NIE, "X0932707B", null);
        Boolean esValidoNie = (nieCorrecto.validarNIE() == true);
        System.out.println( "NIE " + nieCorrecto.numeroDNI + " es: " + esValidoNie.toString());

        DNI nieIncorrecto = new DNI(TIPODNI.NIE, "Z2691139Z", null);
        Boolean esValidoNieIncorrecto = (nieIncorrecto.validarNIE() == true);
        System.out.println( "NIE " + nieIncorrecto.numeroDNI + " es: " + esValidoNieIncorrecto.toString());

        DNI cifCorrecto = new DNI(TIPODNI.CIF, "W9696294I", null);
        Boolean esValidoCIF = (cifCorrecto.validarCIF() == true);
        System.out.println( "CIF " + cifCorrecto.numeroDNI + " es: " + esValidoCIF.toString());

        DNI cifIncorrecto = new DNI(TIPODNI.CIF, "W9696294A", null);
        Boolean esValidoCifIncorrecto = (cifIncorrecto.validarCIF() == true);
        System.out.println( "NIE " + cifIncorrecto.numeroDNI + " es: " + esValidoCifIncorrecto.toString());
    }
}