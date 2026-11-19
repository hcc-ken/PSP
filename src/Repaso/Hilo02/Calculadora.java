package Repaso.Hilo02;

import java.util.concurrent.Semaphore;

public class Calculadora extends Thread{
    public static int par = 0;
    public static int impar = 0;

    private static Semaphore semPar = new Semaphore(1);
    private static Semaphore semImpar = new Semaphore(1);

    public Calculadora(String name) {
        super(name);
        start();
    }

    @Override
    public void run() {

        int longitud = getName().length();

        for (int i = 0; i < longitud; i++) {

            if (longitud % 2 == 0) {

                try {
                    semPar.acquire();

                    par++;

                    System.out.println("Soy " + getName()
                            + " y estoy sumando a even: " + par);

                    semPar.release();

                } catch (InterruptedException e) {
                    System.out.println("Hilo interrumpido");
                }

            } else {

                try {
                    semImpar.acquire();

                    impar++;

                    System.out.println("Soy " + getName()
                            + " y estoy sumando a odd: " + impar);

                    semImpar.release();

                } catch (InterruptedException e) {
                    System.out.println("Hilo interrumpido");
                }
            }
        }
    }
}
