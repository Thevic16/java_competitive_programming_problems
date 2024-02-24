package funciones;

public class CalculadoraSinFunciones {

    public static void main(String[] args) {
        // Calculadora para un cuadrado
        int lado = 5;
        int areaCuadrado = lado * lado;
        int perimetroCuadrado = 4 * lado;

        System.out.println("Área del cuadrado: " + areaCuadrado);
        System.out.println("Perímetro del cuadrado: " + perimetroCuadrado);

        // Calculadora para un rectángulo
        int base = 6;
        int altura = 4;
        int areaRectangulo = base * altura;
        int perimetroRectangulo = 2 * (base + altura);

        System.out.println("Área del rectángulo: " + areaRectangulo);
        System.out.println("Perímetro del rectángulo: " + perimetroRectangulo);
    }
}
