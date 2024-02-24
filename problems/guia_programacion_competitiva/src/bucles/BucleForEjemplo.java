package bucles;

public class BucleForEjemplo {
    public static void main(String[] args) {
        for (int contador = 1; contador <= 5; ++contador) {
            System.out.println("Iteración " + contador);

            if(contador == 3){
                imprimirSaluda();
                break;
            }
        }
    }

    public static void imprimirSaluda(){
        System.out.println("Hola Mundo!");
    }
}
