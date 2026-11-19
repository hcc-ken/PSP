package Repaso.Hilo01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        String[] frases = new String[4];

        for (int i = 0; i < frases.length; i++) {
            System.out.println("Introduce la frase " + (i + 1));
            frases[i] = recogerString();
        }

        System.out.println("Introduce la primera letra:");
        char letra1 = recogerString().charAt(0);

        System.out.println("Introduce la segunda letra:");
        char letra2 = recogerString().charAt(0);

        Contador hilo1 = new Contador("primeraLetra", frases, letra1);
        Contador hilo2 = new Contador("segundaLetra", frases, letra2);

        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            System.out.println("Hilo interrumpido");
        }
        System.out.println("Palabras que terminan en las dos letras: "
                + (Contador.primeraLetra + Contador.segundaLetra));

        System.out.println("Total de palabras: "
                + Contador.totalPalabras);
    }

    private static String recogerString() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String respuesta = "";
        try {
            respuesta = br.readLine();
        } catch (IOException e) {
            System.out.println("Error al leer desde teclado");
        }
        return respuesta;
    }
}
