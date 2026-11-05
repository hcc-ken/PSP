package EjercicioHilos03;

import java.util.concurrent.Semaphore;

public class RelevosHilos extends Thread {
    private static int posicion;
    private static Semaphore semaforo = new Semaphore (1);
    public RelevosHilos(String name) {
        super(name);
        start();
    }

    @Override
    public void run() {
        try {
            semaforo.acquire();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Carrera interrumpido");
        }
        System.out.println(getName() + " está corriendo.");
        System.out.println("Terminé");
        posicion++;
        semaforo.release();

        if (posicion == 4) {
            System.out.println("Carrera terminado");
        }
    }
}
