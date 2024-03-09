//https://www.geeksforgeeks.org/problems/find-abm3912/1

public class Main {
    public static void main(String[] args) {
//        System.out.println(powerMod("3", 2 ,4));
//        System.out.println(powerMod("8", 2 ,6));
        System.out.println(powerMod("4", 0 ,1));
    }

    static long powerMod(String a, long b, long m) {
        long remainderA = -1;

        if(m >1){
            remainderA = calculateTheReminderOfA(a, m);
            return power(remainderA, b, m)+1;
        }
        else{
            remainderA = Long.parseLong(a);
            return power(remainderA, b, m);
        }
    }

    static Long power(Long a, Long b, Long m)
    {
        Long res = 1L;
        a = a % m;
        if (a == 0)
            return 0L;
        while (b > 0) {
            if ((b & 1) == 1)
                res = (res * a) % m;
            b = b >> 1;
            a = (a * a) % m;
        }
        return res;
    }

    static Long calculateTheReminderOfA(String a, long MOD){
        long remainderA = 0;

        // Reduce the number B to a small
        // number using Fermat Little
        for (int i = 0; i < a.length(); i++)
            remainderA = (remainderA * 10 +
                    a.charAt(i) - '0') % (MOD - 1);

        return remainderA;
    }
}