package Procesos01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Encriptar {
    public static void main(String[] args) {
        String password = recogerString();
        String passwordEncriptado = "";

        char[] letras = password.toCharArray();
        for (char letra : letras) {
            passwordEncriptado += (char) (letra - 2);
        }

        System.out.println(passwordEncriptado);
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
