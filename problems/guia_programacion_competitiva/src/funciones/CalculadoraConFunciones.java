package funciones;

public class CalculadoraConFunciones {

    // Función para calcular el área de un cuadrado
    public static int calcularAreaCuadrado(int lado) {
        return lado * lado;
    }

    // Función para calcular el perímetro de un cuadrado
    public static int calcularPerimetroCuadrado(int lado) {
        return 4 * lado;
    }

    // Función para calcular el área de un rectángulo
    public static int calcularAreaRectangulo(int base, int altura) {
        return base * altura;
    }

    // Función para calcular el perímetro de un rectángulo
    public static int calcularPerimetroRectangulo(int base, int altura) {
        return 2 * (base + altura);
    }

    public static void main(String[] args) {
        // Cálculos para un cuadrado usando funciones
        int lado = 5;
        System.out.println("Área del cuadrado: " + calcularAreaCuadrado(lado));
        System.out.println("Perímetro del cuadrado: " + calcularPerimetroCuadrado(lado));

        // Cálculos para un rectángulo usando funciones
        int base = 6;
        int altura = 4;
        System.out.println("Área del rectángulo: " + calcularAreaRectangulo(base, altura));
        System.out.println("Perímetro del rectángulo: " + calcularPerimetroRectangulo(base, altura));
    }
}
