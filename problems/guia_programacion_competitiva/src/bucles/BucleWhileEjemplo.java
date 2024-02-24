package bucles;

public class BucleWhileEjemplo {
    public static void main(String[] args) {
        int contador = 0;

        while (contador <= 100) {
            System.out.println("Iteración " + contador);

            //contador++;
            //contador = contador + 1;
            contador += 10;
        }
    }
}