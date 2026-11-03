package EjercicioHilos03;

public class Main {
    public static void main(String[] args) {
        RelevosHilos relevo1 = new RelevosHilos("Relevo 1");
        RelevosHilos relevo2 = new RelevosHilos("Relevo 2");
        RelevosHilos relevo3 = new RelevosHilos("Relevo 3");
        RelevosHilos relevo4 = new RelevosHilos("Relevo 4");

        try {
            relevo1.join();
            relevo2.join();
            relevo3.join();
            relevo4.join();
        } catch (InterruptedException e) {
            System.out.println("Carrera interrumpida");
        }
    }
}
