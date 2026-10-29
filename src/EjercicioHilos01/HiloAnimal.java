package EjercicioHilos01;

import java.util.concurrent.Semaphore;

public class HiloAnimal extends Thread {
    public static int posicion = 0;
    private int iteracion = 0;
    private static final Semaphore semaforo = new Semaphore(1);

    public HiloAnimal(String name, int prioridad) {
        super(name);
        setPriority(prioridad);
        start();
    }

    @Override
    public void run() {
        iteracion = 0;
        for (int i = 0; i < 10000; i++) {
            try {
                semaforo.acquire();
            } catch (InterruptedException e) {
                System.out.println("Hilo interrumpido");
            }
            iteracion++;
            //System.out.println("Soy el animal " + getName() + " y estoy en la posicion: " + iteracion);
            semaforo.release();
        }
        if (iteracion == 10000) {
            System.out.println("Soy el animal " + getName() + " y estoy en la posicion: " + ++posicion);
            if (posicion == 1) {
                System.out.println("He ganado");
            }
        }
    }
}
