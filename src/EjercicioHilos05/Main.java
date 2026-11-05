package EjercicioHilos05;

public class Main {
    static void main(String[] args) {
        String frase = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam felis dui, mollis nec orci sed, euismod auctor neque. Morbi congue urna quis cursus imperdiet. Nunc id feugiat libero, nec blandit risus. Ut in auctor risus. Nam tellus purus, ultrices non efficitur quis, dapibus vel lectus. Aenean commodo ante ac ex congue, sit amet aliquet lorem placerat. Praesent porta est id nisl cursus, in gravida augue lobortis. Sed tristique dolor augue, eget elementum nisl egestas sollicitudin. Nunc luctus lectus orci, at ultricies magna maximus in.";

        Thread hilo1 = new PalabrasHilos(frase, 0, 200);
        Thread hilo2 = new PalabrasHilos(frase, 201, 400);
        Thread hilo3 = new PalabrasHilos(frase, 0, 200);

        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException e) {
            System.out.println("Hilo interrumpido");
        }

        System.out.println("Palabras: " + PalabrasHilos.totalWords);
        System.out.println("Impares: " + PalabrasHilos.totalOdd);
    }
}
