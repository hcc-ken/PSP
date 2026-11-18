package Procesos.EjercicioSimulacro01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Desencriptar {
     public static void main(String[] args) {
          String password = recogerString();
          String passwordEncriptado = recogerString();

          char[] letras = password.toCharArray();
          for (char letra : letras) {
               passwordEncriptado += (char) (letra - 2); // se pone (char) para que el num ascii sea un caracter en vez de un numero
          }
          System.out.println(passwordEncriptado);
     }

     private static String recogerString() {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          String respuesta = "";

          try {
               respuesta = br.readLine();
          } catch (IOException e) {
               throw new RuntimeException(e);
          }
          return respuesta;
     }
}
