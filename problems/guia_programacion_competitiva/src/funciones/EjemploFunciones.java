package funciones;

public class EjemploFunciones {

    // Definición de una función sin parámetros ni valor de retorno
    public static void saludar() {
        System.out.println("¡Hola, mundo!");
    }

    // Definición de una función con parámetros y valor de retorno
    public static int sumar(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        // Llamada a la función sin parámetros ni valor de retorno
        saludar();

        // Llamada a la función con parámetros y valor de retorno
        int resultado = sumar(5, 3);
        System.out.println("La suma es: " + resultado);
    }
}

