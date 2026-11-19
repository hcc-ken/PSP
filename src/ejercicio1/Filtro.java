package ejercicio1;

import java.io.*;
import java.util.ArrayList;

public class Filtro {
    private static final BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

    private static String recogerString() throws IOException {
        return teclado.readLine();
    }

    public static void main(String[] args) throws IOException {
        String inicial = recogerString().toLowerCase();
        ArrayList<String> filtrados = new ArrayList<>();
        String nombre;
        while ((nombre = recogerString()) != null) {
            if (nombre.toLowerCase().startsWith(inicial)) {
                filtrados.add(nombre);
            }
        }
        for (String resultado : filtrados) {
            System.out.println(resultado);
        }
    }
}
