package ejercicio3;

import java.io.*;
import java.util.ArrayList;

public class Principal {
    private static final BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

    private static String recogerString() throws IOException {
        return teclado.readLine();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ArrayList<String> nombres = new ArrayList<>();
        System.out.println("Introduce un nombre por línea. Escribe end para terminar.");
        String nombre = recogerString();
        while (nombre != null && !nombre.trim().equals("end")) {
            if (!nombre.trim().isEmpty()) {
                nombres.add(nombre.trim());
            }
            nombre = recogerString();
        }

        HiloNombre[] hilos = new HiloNombre[nombres.size()];
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new HiloNombre(nombres.get(i));
            hilos[i].start();
        }
        for (HiloNombre hilo : hilos) {
            hilo.join();
        }
        System.out.println("El número total de letras de los nombres pares es: " + HiloNombre.getEven());
        System.out.println("El número total de letras de los nombres impares es: " + HiloNombre.getOdd());
    }
}
