package bucles;

public class EjemploSumaDigitos {
    public static void main(String[] args) {
        int numero = 12345;
        int suma = 0;

        double numeroDecimal = 1234.5;

        // 12345 % 10 = 1234.5
        // 1234 % 10 = 123.4
        // 123 % 10 = 12.3
        // ...

        while (numero > 0) {
            int residuo = numero % 10;

            suma = suma + residuo;
            //suma += numero % 10;

            numero = numero / 10;
            //numero /= 10;
        }

        System.out.println("La suma de los dígitos es: " + suma);
    }
}
