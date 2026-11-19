package Repaso;

public class Generador {
    public static void main(String[] args) {
        String texto = "";
        int numero = Integer.parseInt(texto);

        String[] lista = {
                "Ana", "Pedro", "Antonio",
                "Lucia", "Alberto", "Maria",
                "Andres", "Carlos", "Andrea",
                "Pablo"
        };

        for (int i = 0; i < numero; i++) {
            int aleatorio = (int) (Math.random() * lista.length);

            System.out.println(lista[aleatorio]);
        }
    }
}
