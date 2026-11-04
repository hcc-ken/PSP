package EjercicioHilos03;

import java.util.concurrent.Semaphore;

public class RelevosHilos extends Thread {
    private static Semaphore semaforo = new Semaphore (1);
    public RelevosHilos(String name) {
        super(name);
        start();
    }

    @Override
    public void run() {
        try {
            semaforo.acquire();
            System.out.println(getName() + " está corriendo.");
            Thread.sleep(3000);
            semaforo.release();
        } catch (InterruptedException e) {
            System.out.println("Carrera interrumpido");
        }
    }
}
