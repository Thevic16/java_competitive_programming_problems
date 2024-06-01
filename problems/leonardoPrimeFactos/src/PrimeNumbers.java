import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Objects;

public class PrimeNumbers {

    public static BigInteger gcd(BigInteger a, BigInteger b) {
        while (!Objects.equals(b, BigInteger.ZERO)) {
            BigInteger t = b;
            b = a.mod(b);
            a = t;
        }
        return a;
    }

    public static ArrayList<Boolean> getPrimeNumbersBooleanList(int n) {
        BigInteger prod = BigInteger.valueOf(2);
        ArrayList<Boolean> booleanList = createBooleanArrayList(n+1);

        booleanList.set(2, true); // set the first prime number

        for (BigInteger prim = BigInteger.valueOf(3); prim.compareTo(BigInteger.valueOf(n)) <= 0; prim = prim.add(BigInteger.valueOf(2))) {
            BigInteger resultGcd = gcd(prod, prim);

            if(resultGcd.compareTo(BigInteger.ONE) == 0){
                prod = prod.multiply(prim);
                booleanList.set(prim.intValue(), true); // set that prime value
            }
        }

        return booleanList;
    }

    public static ArrayList<Boolean> createBooleanArrayList(int n) {
        ArrayList<Boolean> booleanList = new ArrayList<>(n);

        // Llenar la lista con valores predeterminados (en este caso, todos falsos)
        for (int i = 0; i < n; i++) {
            booleanList.add(false);
        }

        return booleanList;
    }


    public static void main(String[] args) {
        ArrayList<Boolean> booleanList = getPrimeNumbersBooleanList(100);
        System.out.println(booleanList);
    }

}
