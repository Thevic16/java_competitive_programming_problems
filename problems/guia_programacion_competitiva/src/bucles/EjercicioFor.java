package bucles;

public class EjercicioFor {
    public static void main(String[] args) {
        int suma = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.println("Iteracion: " + i);
            suma += i;
        }

        System.out.println("La suma es: " + suma);
    }
}
