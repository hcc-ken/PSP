package Repaso.ProcesosRepaso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static String opcion = "";
    public static void main(String[] args) {
        do {
            mostrarOpciones();
            opcion = recogerString();
            realizarOpcion(opcion);

        } while (!opcion.equals("3"));
    }

    private static void mostrarOpciones() {
        System.out.println("Escriba 1 para generar un nombre");
    }

    public static String recogerString() {
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
