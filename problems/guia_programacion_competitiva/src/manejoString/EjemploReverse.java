package manejoString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploReverse {
    public static void main(String[] args) {
        String original = "Anita lava la tina";
        original = original.toLowerCase();
        original = eliminarEspacios(original);

        System.out.println(original);

        StringBuilder invertidoBuilder = new StringBuilder(original).reverse();
        String invertido = invertidoBuilder.toString();
        System.out.println(invertido);

        String textoMultilinea = "Línea 1-Línea 2-Línea 3";
        List<Object> lineas = Arrays.stream(Arrays.stream(textoMultilinea.split("-")).toArray()).toList();

        System.out.println(lineas);

    }
    public static String eliminarEspacios(String input){
        String nuevo = "";

        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) != ' '){
                nuevo += input.charAt(i);
            }
        }

        return nuevo;
    }
}
