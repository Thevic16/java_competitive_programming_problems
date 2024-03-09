import java.util.Scanner;

// https://matcomgrader.com/problem/9763/k-th-common-divisor/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a, b, k;

        a = scanner.nextInt();
        b = scanner.nextInt();
        k = scanner.nextInt();
        int r = -1;

        for (int i = k; i <= 100 ; i++) {
            if(a % i == 0 && b % i == 0 && i >= k){
                r = i;
            }

        }

        System.out.println(r);
        scanner.close();

    }
}