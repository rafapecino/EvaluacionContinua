package Practica1;

import java.util.Random;

public class Matematicas {
    public static double generarNumeroPi(double pasos) {
        double x, y;
        int dentro = 0;
        int fuera = 0;
        Random r = new Random();
        for (int i = 0; i < pasos; i++) {
            x = r.nextDouble();
            y = r.nextDouble();
            if (x * x + y * y <= 1) {
                dentro++;
            } else {
                fuera++;
            }
        }
        return 4.0 * dentro / (dentro + fuera);
    }



        }
