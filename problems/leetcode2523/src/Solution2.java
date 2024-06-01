import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Solution2 {
    public static void main(String[] args) {
        int[] prueba1 = closestPrimes(10, 19);
        int[] prueba2 = closestPrimes(4, 6);
        int[] prueba3 = closestPrimes(19, 31);

        System.out.println(prueba3);
    }

    public static int[] closestPrimes(int left, int right) {
        ArrayList<Integer> listaPrimosRango = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            if(esPrimo(i)){
                listaPrimosRango.add(i);
            }
        }

        List<Integer> resultado = obtenerResultados(listaPrimosRango, Optional.empty(),
                Optional.empty(), Optional.empty());

        return new int[]{resultado.get(0), resultado.get(1)};
    }

    public static boolean esPrimo(int numero) {
        if (numero < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> obtenerResultados(List<Integer> listaPrimosRango, Optional<Integer> left,
                                                  Optional<Integer> right, Optional<Integer> primoAnterior){
        if(listaPrimosRango.isEmpty() && (left.isEmpty() || right.isEmpty())){
            List<Integer> resultados = new ArrayList<>();
            resultados.add(-1);
            resultados.add(-1);
            return resultados;
        } else if (listaPrimosRango.isEmpty()) {
            List<Integer> resultados = new ArrayList<>();
            resultados.add(left.get());
            resultados.add(right.get());
            return resultados;
        } else if (left.isEmpty()) {
            return obtenerResultados(listaPrimosRango.subList(1, listaPrimosRango.size()),
                    Optional.of(listaPrimosRango.get(0)), right, Optional.of(listaPrimosRango.get(0)));
        } else if (right.isEmpty()) {
            return obtenerResultados(listaPrimosRango.subList(1, listaPrimosRango.size()),
                    left, Optional.of(listaPrimosRango.get(0)), Optional.of(listaPrimosRango.get(0)));
        }
        else {
            int diferenciaAnterior = right.get() - left.get();
            int diferenciaActual = listaPrimosRango.get(0) - primoAnterior.get();

            if(diferenciaAnterior <= diferenciaActual){
                return obtenerResultados(listaPrimosRango.subList(1, listaPrimosRango.size()),
                        left, right, Optional.of(listaPrimosRango.get(0)));
            }
            else {
                return obtenerResultados(listaPrimosRango.subList(1, listaPrimosRango.size()),
                        Optional.of(primoAnterior.get()), Optional.of(listaPrimosRango.get(0)),
                        Optional.of(listaPrimosRango.get(0)));
            }
        }
    }


}
