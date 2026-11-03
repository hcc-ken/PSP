package EjercicioHilos02;

import java.io.BufferedReader;
import java.util.concurrent.Semaphore;

public class VocalHilo extends Thread {
    private char vocal;
    public static int contadorVocales = 0;
    private int contadorVocalesIndividual = 0;
    private static Semaphore semaforo = new Semaphore(1);
    public String texto = "Da, DeDe, DiDiDi, DoDoDoDo, DuDuDuDuDu";

    public VocalHilo(char vocal) {
        this.vocal = vocal;
        start();
    }

    @Override
    public void run() {
        for (int i = 0; i < texto.length(); i++) {
            char letra = texto.charAt(i);
            if (letra == vocal) {
                try {
                    semaforo.acquire();
                    contadorVocales++;
                    contadorVocalesIndividual++;
                    semaforo.release();
                    System.out.println("La vocal " + vocal + " aparece " + contadorVocalesIndividual + " veces en el texto.");
                } catch (InterruptedException e) {
                    System.out.println("Hilo interrumpido");
                }
            }
        }
    }
}
