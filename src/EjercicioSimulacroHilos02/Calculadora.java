package EjercicioSimulacroHilos02;

import java.util.concurrent.Semaphore;

public class Calculadora extends Thread{
    private String frase;

    public static int menos5 = 0;
    public static int masIgual5 = 0;

    private static Semaphore semMenos5 = new Semaphore(1);
    private static Semaphore semMasIgual5 = new Semaphore(1);

    public Calculadora(String name, String frase) {
        super(name);
        this.frase = frase;
        start();
    }

    @Override
    public void run(){
        String[] palabras = frase.split("");
        for (String palabra:palabras) {
            if ((palabra.length() <=2 & getName().equals("2")) ||
                    ((palabra.length() == 3 || palabra.length() == 4) && getName().equals("4"))) {
                try {
                    semMenos5.acquire();
                } catch (InterruptedException e) {
                    System.out.println("Hilo interrumpido");
                }
                menos5++;
                semMenos5.release();
            }

            if ((palabra.length() >6 & getName().equals("8")) ||
                    ((palabra.length() == 5 || palabra.length() == 6) && getName().equals("6"))) {
                try {
                    semMasIgual5.acquire();
                } catch (InterruptedException e) {
                    System.out.println("Hilo interrumpido");
                }
                masIgual5++;
                semMasIgual5.release();
            }
        }
    }
}
