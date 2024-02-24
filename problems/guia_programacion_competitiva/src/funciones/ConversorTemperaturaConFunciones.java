package funciones;

public class ConversorTemperaturaConFunciones {

    // Función para convertir Celsius a Fahrenheit
    public static double celsiusAFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    // Función para convertir Fahrenheit a Celsius
    public static double fahrenheitACelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

    public static void main(String[] args) {
        // Conversión de Celsius a Fahrenheit usando funciones
        double celsius = 30;
        System.out.println("Temperatura en Fahrenheit: " + celsiusAFahrenheit(celsius));

        // Conversión de Fahrenheit a Celsius usando funciones
        double temperaturaFahrenheit = 86;
        System.out.println("Temperatura en Celsius: " + fahrenheitACelsius(temperaturaFahrenheit));
    }
}
