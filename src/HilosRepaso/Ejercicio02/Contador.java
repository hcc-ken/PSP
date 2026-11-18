package HilosRepaso.Ejercicio02;

import java.util.concurrent.Semaphore;

public class Contador extends Thread{
    private String frase;
    private char num;

    private static int contadorGlobal = 0;
    private int contadorLocal = 0;
    private static Semaphore semaphore = new Semaphore(1);

    public Contador(String frase, char num) {
        this.frase = frase;
        this.num = num;
        start();
    }

    @Override
    public void run() {
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == num) {
                contadorLocal++;
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                contadorGlobal++;
                semaphore.release();
            }
        }
        System.out.println("Soy el hilo" + num + " he salido " + contadorLocal + " veces");
    }
}
