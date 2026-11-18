package Procesos.EjercicioSimulacro01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {
    private static String opcion = "";
    private static String usuario = "";
    private static String password = "";
    private static String passwordEnc = "";
    public static void main(String[] args) {
        do {
            mostrarOpciones();
            opcion = recogerString();
            realizarOpcion(opcion);
        } while (!opcion.equals("3"));
    }

    private static void mostrarOpciones() {
        System.out.println("Seleccione una opcion\n" +
                "1. Registrarse.\n" +
                "2. Acreditarse. \n" +
                "3. Salir");
    }

    private static void realizarOpcion(String opcion) {
        switch (opcion) {
            case "1" -> registrarse();
            case "2" -> acreditarse();
            case "3" -> System.out.println("Saliendo...");
            default -> System.out.println("Opcion incorrecta.");
        }
    }

    private static void acreditarse() {
        String nuevoUsuario = "";
        do {
            System.out.println("Dime el usuario");
            nuevoUsuario = recogerString();
            if (!usuario.equals(nuevoUsuario)) {
                System.out.println("Usuario incorrecto");
            }
        } while (!usuario.equals(nuevoUsuario));

        String password = "";
        String passwordDesenc = "";
        do {
            System.out.println("Dime el password");
            password = recogerString();
            passwordDesenc = desencriptarPassword();
            if (!password.equals(passwordDesenc)) {
                System.out.println("Password incorrecto");
            }
        } while (!password.equals(passwordDesenc));

        System.out.println("Bienvenido " + usuario);
    }

    private static String desencriptarPassword() {
        String[] comandoDesencriptar = {"java", "-jar", "out/artifacts/desencriptar/desencriptar.jar"};

        Process proceso = crearProceso(comandoDesencriptar);

        if (proceso != null) {
            escribirEnProceso(passwordEnc, proceso);
            return leerDesdeProceso(proceso);
        }
        return null;
    }

    private static void registrarse() {
        System.out.println("Dime el usuario");
        usuario = recogerString();

        System.out.println("Dime la contraseña");
        password = recogerString();

        Process procesoEncriptar = generarProcesoEncriptar();
        if (procesoEncriptar != null) {
            escribirEnProceso(password, procesoEncriptar);
            passwordEnc = leerDesdeProceso(procesoEncriptar);
        }
    }

    private static Process generarProcesoEncriptar() {
        String[] comandoEncriptar = {"java", "-jar", "out/artifacts/encriptar/encriptar.jar"};
        Process proces = crearProceso(comandoEncriptar);
        
        return null;
    }

    private static Process crearProceso(String[] comandoEncriptar) {
        ProcessBuilder pb = new ProcessBuilder(comandoEncriptar);
        Process process = null;

        try {
            process = pb.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return process;
    }

    private static String leerDesdeProceso(Process process) {
        BufferedReader brHijo = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String respuesta = "";

        try {
            respuesta = brHijo.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return respuesta;
    }

    private static void escribirEnProceso(String password, Process process) {
        PrintStream ps = new PrintStream(process.getOutputStream());
        ps.println(password);
        ps.close();
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

