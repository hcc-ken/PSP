package Repaso.ProcesosRepaso;

import static Repaso.ProcesosRepaso.Main.recogerString;

public class Filtro {
    public static void main (String[] args) {
        String letra = recogerString();
        String nombre = recogerString();

        while (nombre != null) {
            if (nombre.equals("") && letra.equals("")){
                System.out.println(nombre);
            }
            nombre=recogerString();
        }
    }

}
