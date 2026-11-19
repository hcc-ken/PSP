package ejercicio2;

import java.io.*;
import java.util.ArrayList;

public class Principal {
    private static final BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

    private static String recogerString() throws IOException {
        return teclado.readLine();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ArrayList<String> palabras = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            System.out.println("Introduce la frase " + i + ":");
            String[] partes = recogerString().trim().split("\\s+");
            for (String palabra : partes) {
                if (!palabra.isEmpty()) {
                    palabras.add(palabra);
                }
            }
        }

        char primera = pedirLetra("primera");
        char segunda = pedirLetra("segunda");
        Contador hilo1 = new Contador("primeraLetra", palabras, primera);
        Contador hilo2 = new Contador("segundaLetra", palabras, segunda);
        hilo1.start();
        hilo2.start();
        hilo1.join();
        hilo2.join();

        int coincidencias = Contador.getTotal();
        if (primera == segunda) {
            // Ambos hilos han contado las mismas palabras.
            coincidencias /= 2;
        }
        System.out.println("Palabras que terminan en alguna de las dos letras: " + coincidencias);
        System.out.println("Total de palabras: " + palabras.size());
    }

    private static char pedirLetra(String orden) throws IOException {
        System.out.println("Introduce la " + orden + " letra:");
        String texto = recogerString().trim().toLowerCase();
        while (texto.length() != 1 || !Character.isLetter(texto.charAt(0))) {
            System.out.println("Introduce una sola letra:");
            texto = recogerString().trim().toLowerCase();
        }
        return texto.charAt(0);
    }
}
