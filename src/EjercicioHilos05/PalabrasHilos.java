package EjercicioHilos05;

import java.util.concurrent.Semaphore;

public class PalabrasHilos extends Thread {
    private String texto;
    private int caracterInicial;
    private int caracterFinal;

    public static int totalWords = 0;
    public static int totalOdd = 0;
    private static Semaphore semTotal = new Semaphore(1);
    private static Semaphore semOdd = new Semaphore(1);

    public PalabrasHilos(String texto, int caracterInicial, int caracterFinal) {
        this.texto = texto;
        this.caracterInicial = caracterInicial;
        this.caracterFinal = caracterFinal;
        start();
    }

    @Override
    public void run() {
        int contador = 0;
        int impares = 0;
        String fragmento = texto.substring(caracterInicial, caracterFinal);
        String[] palabritas = fragmento.split(" ");

        for (String palabra: palabritas) {
            contador++;
            try {
                semTotal.acquire();
            } catch (InterruptedException e) {
                System.out.println("Interrumpido");
            }
            totalWords++;
            semTotal.release();

            if (palabra.length() % 2 == 0) {
                impares++;
                try {
                    semOdd.acquire();
                } catch (InterruptedException e) {
                    System.out.println("Interrumpido");
                }
                totalOdd++;
                semOdd.release();
            }
        }
        System.out.println("Entre la posicion " + caracterInicial + " y la posicion " + caracterFinal + " hay " + contador + " palabras");
    }
}
