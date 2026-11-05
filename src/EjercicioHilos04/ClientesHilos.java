package EjercicioHilos04;

import java.util.concurrent.Semaphore;

public class ClientesHilos extends Thread{
    private int cantidad;
    private String categoria;
    public static int dinero = 100000;
    public static int dineroPlus = 500000;
    private static Semaphore semDinero = new Semaphore(1);
    private static Semaphore semPlus = new Semaphore(1);

    public ClientesHilos(String name, int cantidad, String categoria){
        super(name);
        this.cantidad = cantidad;
        this.categoria = categoria;
        start();
    }

    @Override
    public void run(){
        System.out.println(getName() + " llega al banco");
        System.out.println(getName() + " pide permiso para entrar");

        try {
            semDinero.acquire();
        } catch (InterruptedException e) {
            System.out.println("Hilo interrumpido");
        }

        dinero += cantidad;
        dinero -= 1000;
        System.out.println(getName() + " sale de la cámara");
        semDinero.release();

        if (categoria.equals("PLUS")){
            System.out.println(getName() + " pide permiso para entrar a la camara PLUS");
            try {
                semPlus.acquire();
            } catch (InterruptedException e) {
                System.out.println("Hilo interrumpido");
            }
            System.out.println(getName() + " entra a la cámara");
        }
        int porcentaje = cantidad / 100;
        dineroPlus -= porcentaje;
        cantidad += dineroPlus;
        System.out.println(getName() + " sale de la cámara acorazada PLUS.");
    }
}
