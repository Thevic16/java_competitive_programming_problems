package aritmeticaModular;

public class CicloHorasAritmeticaModular {
    public static void main(String[] args) {
        int numeroIteraciones = 100;

        System.out.println("Cálculo de las horas en un reloj de 12 horas:");

        for (int horaActual = 3; horaActual <= numeroIteraciones; horaActual++) { // Supongamos que la hora actual es 3 am en un reloj de 12 horas
            System.out.println("Han pasado " + horaActual + " Horas eso equivale en el reloj a: " + obtenerFormatoHora(horaActual));
        }
    }

    static String obtenerFormatoHora(int hora) {
        if(hora % 24 == 0){
            return "12 PM";
        }
        else if (hora % 12 == 0) {
            return "12 AM";
        } else if (hora % 24 < 12) {
            return hora % 12 + " AM";
        } else {
            return (hora % 12) + " PM";
        }
    }
}

