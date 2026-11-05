package EjercicioHilos04;

public class Main {
    public static void main(String[] args){
        Thread andrea = new ClientesHilos("Andrea", 5000, "SINGLE");
        Thread leo = new ClientesHilos("Leo", 4000, "plus");
        Thread sans = new ClientesHilos("Sans", 6000, "SINGLE");
        Thread sara = new ClientesHilos("Sara", 7000, "PLUS");

        try {
            andrea.join();
            leo.join();
            sans.join();
            sara.join();
        } catch (InterruptedException e) {
            System.out.println("Interrumpido");
        }

        System.out.println("El dinero final del dia es: " + ClientesHilos.dinero);
        System.out.println("El dinero PLUS final del dia es: " + ClientesHilos.dineroPlus);
    }
}
