package EjercicioHilos03;

public class RelevosHilos extends Thread {
    public RelevosHilos(String name) {
        super(name);
        start();
    }

    @Override
    public void run() {}
}
