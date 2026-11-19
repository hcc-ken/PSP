package ejercicio3;

import java.util.concurrent.Semaphore;

public class HiloNombre extends Thread {
    private static int even = 0;
    private static int odd = 0;
    private static final Semaphore semPar = new Semaphore(1);
    private static final Semaphore semImpar = new Semaphore(1);

    public HiloNombre(String nombre) {
        super(nombre);
    }

    @Override
    public void run() {
        int longitud = getName().length();
        boolean esPar = longitud % 2 == 0;
        Semaphore semaforo = semImpar;
        if (esPar) {
            semaforo = semPar;
        }

        try {
            semaforo.acquire();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
        try {
            for (int i = 0; i < longitud; i++) {
                if (esPar) {
                    even++;
                    System.out.println(getName() + " suma 1 a even. Total: " + even);
                } else {
                    odd++;
                    System.out.println(getName() + " suma 1 a odd. Total: " + odd);
                }
            }
        } finally {
            semaforo.release();
        }
    }

    public static int getEven() {
        return even;
    }

    public static int getOdd() {
        return odd;
    }
}
