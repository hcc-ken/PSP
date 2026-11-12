package EjercicioSimulacroHilos01;

import EjercicioSimulacroHilos01.Contador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main (String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Escriba una frase.");
        String frase = recogerString();
        try {
            frase = br.readLine();
        } catch (IOException e) {
            System.out.println("Se ha producido un error");
        }

        Thread hilo0 = new Contador(frase, '0');
        Thread hilo1 = new Contador(frase, '1');
        Thread hilo2 = new Contador(frase, '2');
        Thread hilo3 = new Contador(frase, '3');
        Thread hilo4 = new Contador(frase, '4');
        Thread hilo5 = new Contador(frase, '5');
        Thread hilo6 = new Contador(frase, '6');
        Thread hilo7 = new Contador(frase, '7');
        Thread hilo8 = new Contador(frase, '8');
        Thread hilo9 = new Contador(frase, '9');

        try {
            hilo0.join();
            hilo1.join();
            hilo2.join();
            hilo3.join();
            hilo4.join();
            hilo6.join();
            hilo7.join();
            hilo8.join();
            hilo9.join();
        } catch (InterruptedException e) {
            System.out.println("Interrumpido");
        }
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
