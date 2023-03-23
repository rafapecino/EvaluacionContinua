package Practica1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int puntosTotales = 1000000;
        int aciertos = 0;
        double radio = 1.0;
        Random rnd = new Random();


        for (int i = 0; i < puntosTotales; i++) {
            double x = rnd.nextDouble() * 2 - 1; // número aleatorio entre -1 y 1
            double y = rnd.nextDouble() * 2 - 1; // número aleatorio entre -1 y 1

            if (Math.sqrt(x * x + y * y) <= radio) {
                aciertos++;
            }
        }

        double areaCuadrado = 4.0;
        double aproximacionPi = areaCuadrado * aciertos / puntosTotales;
        System.out.println("Aproximación al número pi: " + aproximacionPi);
    }
}
