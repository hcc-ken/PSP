package HilosRepaso.Ejercicio01;

public class HilosAnimal extends Thread{
    public HilosAnimal(String name, int prioridad) {
        super(name);
        setPriority(prioridad);
        start();
    }
}
