package Repaso.Hilo01;

import java.util.concurrent.Semaphore;

public class Contador extends Thread{
    private String[] frases;
    private char letra;

    public static int primeraLetra = 0;
    public static int segundaLetra = 0;
    public static int totalPalabras = 0;

    private int contador = 0;

    private static Semaphore sem = new Semaphore(1);


    public Contador(String name, String[] frases, char letra) {
        super(name);
        this.frases = frases;
        this.letra = letra;
        start();
    }

    @Override
    public void run() {

        for (String frase : frases) {

            String[] palabras = frase.split(" ");

            for (String palabra : palabras) {

                if (palabra.length() > 0) {

                    if (palabra.charAt(palabra.length() - 1) == letra) {

                        contador++;

                        try {
                            sem.acquire();

                            if (getName().equals("primeraLetra")) {
                                primeraLetra++;
                            } else {
                                segundaLetra++;
                            }

                        } catch (InterruptedException e) {
                            System.out.println("Hilo interrumpido");
                        } finally {
                            sem.release();
                        }
                    }
                }
            }
        }

        // Solo un hilo cuenta el total de palabras. Hazlo o no lo hagas. Depende de si quieres que se sospeche mucho o no
        if (getName().equals("primeraLetra")) {

            for (String frase : frases) {

                String[] palabras = frase.split(" ");

                for (String palabra : palabras) {

                    if (palabra.length() > 0) {
                        totalPalabras++;
                    }
                }
            }
        }

        System.out.println("Soy el hilo " + getName()
                + ", mi letra es " + letra
                + " y he encontrado " + contador + " palabras");
    }
}
