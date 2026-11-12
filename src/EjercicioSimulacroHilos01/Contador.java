package EjercicioSimulacroHilos01;

import java.util.concurrent.Semaphore;

public class Contador extends Thread{
    private String frase;
    private char num;

    public static int contadorGlobal = 0;
    private int contador = 0;
    private static Semaphore sem = new Semaphore(1);

    public Contador(String frase, char num) {
        this.frase = frase;
        this.num = num;
        start();
    }

    @Override
    public void run() {
        for (int i = 0; i < frase.length(); i++){
            if (frase.charAt(i) == num) {
                contador++;
                try {
                    sem.acquire();
                } catch (InterruptedException e) {
                    System.out.println("Semaforo interrumpido");
                }
                contadorGlobal++;
                sem.release();
            }
        }
        System.out.println("El total de apariciones del número "+ num + " es " + contador);
        System.out.println("Total: ");
    }
}