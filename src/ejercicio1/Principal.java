package ejercicio1;

import java.io.*;
import java.util.ArrayList;

public class Principal {
    private static final BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

    private static String recogerString() throws IOException {
        return teclado.readLine();
    }

    public static void main(String[] args) {
        try {
            mostrarOpciones();
            if ("1".equals(recogerString())) {
                generarNombres();
            }
        } catch (IOException e) {
            System.out.println("Error de comunicación: " + e.getMessage());
        }
    }

    private static void mostrarOpciones() {
        System.out.println("1. Generar nombres");
    }

    private static void generarNombres() throws IOException {
        System.out.println("¿Quieres filtrar por inicial? Escribe una letra o pulsa Intro para omitirla.");
        String inicial = recogerString().trim();
        while (inicial.length() > 1) {
            System.out.println("Introduce una sola letra o pulsa Intro.");
            inicial = recogerString().trim();
        }

        int cantidad = pedirCantidad();
        String[] comando = {"java", "-jar", "out/artifacts/generador/generador.jar"};
        Process generador = generarProceso(comando);
        PrintStream salida = new PrintStream(generador.getOutputStream());
        salida.println(cantidad);
        salida.close();

        ArrayList<String> nombres = leerLista(generador);
        if (!inicial.isEmpty()) {
            nombres = filtrarNombres(nombres, inicial);
        }

        if (nombres.isEmpty()) {
            System.out.println("La lista está vacía.");
        }
        for (String nombre : nombres) {
            System.out.println(nombre);
        }
    }

    private static int pedirCantidad() throws IOException {
        while (true) {
            System.out.println("Número de nombres:");
            try {
                int cantidad = Integer.parseInt(recogerString().trim());
                if (cantidad >= 0) {
                    return cantidad;
                }
            } catch (NumberFormatException e) {
                // Volvemos a pedir la cantidad.
            }
            System.out.println("Introduce un entero mayor o igual que cero.");
        }
    }

    private static Process generarProceso(String[] comando) throws IOException {
        ProcessBuilder pb = new ProcessBuilder(comando);
        return pb.start();
    }

    private static ArrayList<String> leerLista(Process hijo) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
        ArrayList<String> nombres = new ArrayList<>();
        String linea;
        while ((linea = br.readLine()) != null) {
            nombres.add(linea);
        }
        br.close();
        return nombres;
    }

    private static ArrayList<String> filtrarNombres(ArrayList<String> nombres, String inicial)
            throws IOException {
        String[] comando = {"java", "-jar", "out/artifacts/filtro/filtro.jar"};
        Process filtro = generarProceso(comando);
        PrintStream salida = new PrintStream(filtro.getOutputStream());
        salida.println(inicial);
        for (String nombre : nombres) {
            salida.println(nombre);
        }
        salida.close(); // El hijo ya puede detectar el final de la lista.
        return leerLista(filtro);
    }
}
