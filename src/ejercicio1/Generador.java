package ejercicio1;

import java.io.*;

public class Generador {
    private static final BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

    private static String recogerString() throws IOException {
        return teclado.readLine();
    }

    public static void main(String[] args) throws IOException {
        String[] nombres = {"Ana", "Alba", "Bruno", "Carla", "Diego", "Elena", "Julia", "Pablo"};
        int cantidad = Integer.parseInt(recogerString());
        for (int i = 0; i < cantidad; i++) {
            int posicion = (int) (Math.random() * nombres.length);
            System.out.println(nombres[posicion]);
        }
    }
}
