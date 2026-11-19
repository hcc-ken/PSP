package Repaso.Hilo02;

import EjercicioSimulacroHilos01.Contador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Calculadora> hilos = new ArrayList<>();

        String nombre = "";

        do {
            System.out.println("Introduce un nombre (Esc para terminar):");
            nombre = recogerString();

            if (!nombre.equals("Esc")) {
                Calculadora hilo = new Calculadora(nombre);
                hilos.add(hilo);
            }

        } while (!nombre.equals("Esc"));

        for (Calculadora hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                System.out.println("Hilo interrumpido");
            }
        }

        System.out.println("El numero total de letras de los nombres pares es: "
                + Calculadora.par);

        System.out.println("El numero total de letras de los nombres impares es: "
                + Calculadora.impar);
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