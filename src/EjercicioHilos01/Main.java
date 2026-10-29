package EjercicioHilos01;

public class Main {
    static void main() {
        HiloAnimal hiloLiebre = new HiloAnimal("liebre", 10);
        HiloAnimal hiloGuepardo = new HiloAnimal("guepardo", 5);
        HiloAnimal hiloTortuga = new HiloAnimal("tortuga", 1);

        try {
            hiloLiebre.join();
            hiloGuepardo.join();
            hiloTortuga.join();
        } catch (InterruptedException e) {
            System.out.println("Carrera interrumpida");
        }
    }
}
