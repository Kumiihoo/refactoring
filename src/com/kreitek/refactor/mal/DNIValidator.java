package com.kreitek.refactor.mal;

public class DNIValidator implements Validator{
    @Override
    public boolean validator() {
        String dniChars="TRWAGMYFPDXBNJZSQVHLCKE";
        String intPartDNI = DNI.numeroDNI.trim().replaceAll(" ", "").substring(0, 8);
        char letraDNI = DNI.numeroDNI.charAt(8);
        int valnumeroDNI = Integer.parseInt(intPartDNI) % 23;

        return DNI.numeroDNI.length() == 9 && isNumeric(intPartDNI) && dniChars.charAt(valnumeroDNI) == letraDNI;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
