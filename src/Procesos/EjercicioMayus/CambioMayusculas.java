package Procesos.EjercicioMayus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CambioMayusculas {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String texto;

        try {
            texto = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(texto.toUpperCase());
    }
}