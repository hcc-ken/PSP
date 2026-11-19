package ejercicio2;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Contador extends Thread {
    private ArrayList<String> palabras;
    private char letra;
    private static int total = 0;
    private static final Semaphore semaforo = new Semaphore(1);

    public Contador(String nombre, ArrayList<String> palabras, char letra) {
        super(nombre);
        this.palabras = palabras;
        this.letra = letra;
    }

    @Override
    public void run() {
        int contadorLocal = 0;
        for (String palabra : palabras) {
            String texto = palabra.toLowerCase();
            if (texto.charAt(texto.length() - 1) == letra) {
                contadorLocal++;
            }
        }

        try {
            semaforo.acquire();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
        try {
            total += contadorLocal;
        } finally {
            semaforo.release();
        }

        System.out.println(getName() + " - letra " + letra + ": " + contadorLocal + " palabras.");
    }

    public static int getTotal() {
        return total;
    }
}
