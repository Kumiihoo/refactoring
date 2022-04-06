package com.kreitek.refactor.mal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CIFValidator implements Validator{
    @Override
    public boolean validator() {
        if (DNI.numeroDNI != null) {
            final String cifUP = DNI.numeroDNI.toUpperCase();

            if ("ABCDEFGHJKLMNPQRSUVW".indexOf(cifUP.charAt(0)) == -1) {
                return false;
            }

            final Pattern mask = Pattern
                    .compile("[ABCDEFGHJKLMNPQRSUVW][0-9]{7}[A-Z0-9]");
            final Matcher matcher = mask.matcher(cifUP);
            if (!matcher.matches()) {
                return false;
            }

            final char primerCar = cifUP.charAt(0);
            final char ultimoCar = cifUP.charAt(cifUP.length() - 1);


            TipoUltCaracter tipUltCar;

            if (primerCar == 'P' || primerCar == 'Q' || primerCar == 'S' || primerCar == 'K' || primerCar == 'W') {
                tipUltCar = TipoUltCaracter.LETRA;
                if (!(ultimoCar >= 'A' && ultimoCar <= 'Z')) {
                    return false;
                }

            } else if (primerCar == 'A' || primerCar == 'B' || primerCar == 'E'
                    || primerCar == 'H') {
                tipUltCar = TipoUltCaracter.NUMERO;
                if (!(ultimoCar >= '0' && ultimoCar <= '9')) {
                    return false;
                }

            } else {
                tipUltCar = TipoUltCaracter.AMBOS;
            }


            final String digitos = cifUP.substring(1, cifUP.length() - 1);


            int sumaPares = 0;
            for (int i = 1; i <= digitos.length() - 1; i = i + 2) {
                sumaPares += Integer.parseInt(digitos.substring(i, i + 1));
            }


            int sumaImpares = 0;
            for (int i = 0; i <= digitos.length() - 1; i = i + 2) {
                int cal = Integer.parseInt(digitos.substring(i, i + 1)) * 2;
                if (Integer.toString(cal).length() > 1) {
                    cal = Integer.parseInt(Integer.toString(cal).substring(0, 1))
                            + Integer.parseInt(Integer.toString(cal).substring(1, 2));
                }
                sumaImpares += cal;
            }


            final int total = sumaPares + sumaImpares;


            int numControl = 10 - (total % 10);

            int pos = numControl == 10? 0:numControl;
            final char carControl = "JABCDEFGHI".charAt(pos);


            if (tipUltCar == TipoUltCaracter.NUMERO) {

                final int ultCar = Integer.parseInt(Character
                        .toString(ultimoCar));
                return pos == ultCar;

            } else if (tipUltCar == TipoUltCaracter.LETRA) {
                return carControl == ultimoCar;

            } else {

                int ultCar;

                ultCar = "JABCDEFGHI".indexOf(ultimoCar);

                if (ultCar < 0){
                    ultCar = Integer.parseInt(Character.toString(ultimoCar));
                    if (pos != ultCar) {
                        return false;
                    }
                }
                return (pos == ultCar) || (carControl == ultimoCar);
            }
        }
        return false;
    }
}
