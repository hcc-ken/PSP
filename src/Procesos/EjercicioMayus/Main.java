package Procesos.EjercicioMayus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        String frase = "";

        System.out.println("Dime una frase");
        frase = recogerString();
        Process proceso = generarSubproceso();
        escribirEnHijo(proceso, frase); //Este metodo sirve para escribirle al hijo. proceso es el hijo a quien el padre a escribir, frase es lo que el padre l envía
        String respuesta = leerdesdeHijo(proceso);
        System.out.println("La respuesta es: " + (respuesta));
    }

    private static String leerdesdeHijo(Process proceso) {
        BufferedReader brHijo = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
        String respuesta = "";

        try {
            respuesta = brHijo.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return respuesta;
    }

    private static void escribirEnHijo(Process proceso, String frase) { //Este metodo sirve para escribirle al hijo. proceso es el hijo a quien el padre a escribir, frase es lo que el padre l envía
        PrintStream ps = new PrintStream(proceso.getOutputStream());
        ps.println(frase);
        ps.close();
    }

    private static Process generarSubproceso() {
        String[] comando = {"java", "-jar", "out/artifacts/cambiomayusculas/cambiomayusculas.jar"};

        ProcessBuilder pb = new ProcessBuilder(comando);
        Process proceso = null;

        try {
            proceso = pb.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return proceso;
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
