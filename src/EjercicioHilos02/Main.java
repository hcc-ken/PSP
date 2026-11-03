package EjercicioHilos02;

public class Main {
   static void main() {
        VocalHilo hiloA = new VocalHilo('a');
        VocalHilo hiloE = new VocalHilo('e');
        VocalHilo hiloI = new VocalHilo('i');
        VocalHilo hiloO = new VocalHilo('o');
        VocalHilo hiloU = new VocalHilo('u');

        try {
            hiloA.join();
            hiloE.join();
            hiloI.join();
            hiloO.join();
            hiloU.join();
        } catch (InterruptedException e) {
            System.out.println("Carrera interrumpida");
        }
    }
}
