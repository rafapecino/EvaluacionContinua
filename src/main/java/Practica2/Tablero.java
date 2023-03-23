package Practica2;

import java.util.Arrays;

public class Tablero {
    private int[][] tablero;
    private int filas;
    private int columnas;

    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        tablero = new int[filas][columnas];
    }

    @Override
    public String toString() {
        return "Tablero{" +
                "tablero=" + Arrays.toString(tablero) +
                ", filas=" + filas +
                ", columnas=" + columnas +
                '}';
    }

    public void mostrarTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void ponerReina(int fila, int columna) {
        tablero[fila][columna] = 1;
    }

    public void quitarReina(int fila, int columna) {
        tablero[fila][columna] = 0;
    }

    public boolean esValido(int fila, int columna) {
        for (int i = 0; i < columnas; i++) {
            if (tablero[fila][i] == 1) {
                return false;
            }
        }
        for (int i = 0; i < filas; i++) {
            if (tablero[i][columna] == 1) {
                return false;
            }
        }
        for (int i = fila, j = columna; i >= 0 && j >= 0; i--, j--) {
            if (tablero[i][j] == 1) {
                return false;
            }
        }
        for (int i = fila, j = columna; i < filas && j >= 0; i++, j--) {
            if (tablero[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public boolean resolver(int columna) {
        if (columna >= columnas) {
            return true;
        }
        for (int i = 0; i < filas; i++) {
            if (esValido(i, columna)) {
                ponerReina(i, columna);
                if (resolver(columna + 1)) {
                    return true;
                }
                quitarReina(i, columna);
            }
        }
        return false;
    }

    public void resolver() {
        if (resolver(0)) {
            mostrarTablero();
        } else {
            System.out.println("No hay solución");
        }
}

    public void transitarAlEstadoSiguiente() {
        int[][] tableroAux = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int vecinas = contarVecinasVivas(i, j);
                if (tablero[i][j] == 1) {
                    if (vecinas < 2 || vecinas > 3) {
                        tableroAux[i][j] = 0;
                    } else {
                        tableroAux[i][j] = 1;
                    }
                } else {
                    if (vecinas == 3) {
                        tableroAux[i][j] = 1;
                    } else {
                        tableroAux[i][j] = 0;
                    }
                }
            }
        }
        tablero = tableroAux;
    }

    private int contarVecinasVivas(int i, int j) {
        int vecinas = 0;
        if (i - 1 >= 0 && j - 1 >= 0 && tablero[i - 1][j - 1] == 1) {
            vecinas++;
        }
        if (i - 1 >= 0 && tablero[i - 1][j] == 1) {
            vecinas++;
        }
        if (i - 1 >= 0 && j + 1 < columnas && tablero[i - 1][j + 1] == 1) {
            vecinas++;
        }
        if (j - 1 >= 0 && tablero[i][j - 1] == 1) {
            vecinas++;
        }
        if (j + 1 < columnas && tablero[i][j + 1] == 1) {
            vecinas++;
        }
        if (i + 1 < filas && j - 1 >= 0 && tablero[i + 1][j - 1] == 1) {
            vecinas++;
        }
        if (i + 1 < filas && tablero[i + 1][j] == 1) {
            vecinas++;
        }
        if (i + 1 < filas && j + 1 < columnas && tablero[i + 1][j + 1] == 1) {
            vecinas++;
        }
        return vecinas;
    }

    public void generarEstadoActualPorMontecarlo() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = (int) (Math.random() * 2);
            }
        }
    }

    public void leerEstadoActual() {
        // leer el estado actual del tablero
    }
}
