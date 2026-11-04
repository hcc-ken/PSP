package EjercicioHilos03;

public class Main {
    public static void main(String[] args) {
        RelevosHilos relevo1 = new RelevosHilos("Relevo 1");
        RelevosHilos relevo2 = new RelevosHilos("Relevo 2");
        RelevosHilos relevo3 = new RelevosHilos("Relevo 3");
        RelevosHilos relevo4 = new RelevosHilos("Relevo 4");

        RelevosHilos[] corredores = {relevo1, relevo2, relevo3, relevo4};

        for (int i = 0; i < corredores.length; i++) {
            try {
                corredores[i].join();
            } catch (InterruptedException e) {
                System.out.println("Carrera interumpida");
            }
        }
        System.out.println("La carrera ha finalizado");
    }
}
