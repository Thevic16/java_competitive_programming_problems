package bucles;
import java.util.Scanner;

public class EjemploWhileInput {
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();

        while (n != 100){
            System.out.println("Trate otra vez!!!");
            n = scanner.nextInt();
        }

//        for (int n = 0; n != 100 ;) {
//            n = scanner.nextInt();
//            System.out.println("Trate otra vez!!!");
//        }

        System.out.println("FIN!!!!");
    }
}
