package aritmeticaModular;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EjemploBasicoCicloEquivalencia {
    public static void main(String[] args) {
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

        int m = 12;

        for (int i = 0; i < 12; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < 100; i++) {
            int x = i % m;
            //System.out.println("Iteración: " + i + " % (12) = " + x);
            map.get(x).add(i);
        }

        for (int i = 0; i < 12; i++) {
            System.out.println("Modulo " + i + " = " + map.get(i));
        }

    }
}
