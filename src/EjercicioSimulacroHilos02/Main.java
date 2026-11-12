package EjercicioSimulacroHilos02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static void main(String[] args) {
        System.out.println("Dime una frase");
        String frase = recogerString();

        Thread hilo2 = new Calculadora("2", frase);
        Thread hilo4 = new Calculadora("4", frase);
        Thread hilo6 = new Calculadora("6", frase);
        Thread hilo8 = new Calculadora("8", frase);

        try {
            hilo2.join();
            hilo4.join();
            hilo6.join();
            hilo8.join();
        } catch (InterruptedException e) {
            System.out.println("Hilo interrumpido");
        }
        System.out.println("Total  de palabras de 5 o mas letras es: " + Calculadora.masIgual5);
        System.out.println("Total  de palabras de 5 o menos letras es: " + Calculadora.menos5);
    }

    private static String recogerString() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String respuesta = "";
        try {
            respuesta = br.readLine();
        } catch (IOException e) {
            System.out.println("Error al leer desde teclado." + e.getMessage());
        }
        return respuesta;
    }
}
