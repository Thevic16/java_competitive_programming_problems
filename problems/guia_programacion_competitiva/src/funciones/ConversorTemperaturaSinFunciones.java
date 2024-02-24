package funciones;

public class ConversorTemperaturaSinFunciones {

    public static void main(String[] args) {
        // Conversión de Celsius a Fahrenheit
        double celsius = 30;
        double fahrenheit = (celsius * 9/5) + 32;
        System.out.println("Temperatura en Fahrenheit: " + fahrenheit);

        // Conversión de Fahrenheit a Celsius
        double temperaturaFahrenheit = 86;
        double temperaturaCelsius = (temperaturaFahrenheit - 32) * 5/9;
        System.out.println("Temperatura en Celsius: " + temperaturaCelsius);
    }
}
