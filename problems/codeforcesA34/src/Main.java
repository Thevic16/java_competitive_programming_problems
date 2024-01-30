import java.util.*;

// https://codeforces.com/contest/34/problem/A

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n;
        List<Soldier> soldierList = new ArrayList<>();

        n = scanner.nextInt();

        for(int i = 0; i < n; i++){
            int h = scanner.nextInt();
            Soldier s = new Soldier();
            s.index = i+1;
            s.height = h;
            soldierList.add(s);
        }

        int minimalDifference = Math.abs(soldierList.get(0).height - soldierList.get(n-1).height);
        Soldier soldier1 = soldierList.get(0);
        Soldier soldier2 = soldierList.get(n-1);
        //Collections.sort(soldierList, Comparator.comparingInt(Soldier::getHeight));

        for (int i = 0; i <= n-2; i++) {
            int difference = Math.abs(soldierList.get(i).height - soldierList.get(i+1).height);
            if(difference < minimalDifference){
                minimalDifference = difference;
                soldier1 = soldierList.get(i);
                soldier2 = soldierList.get(i+1);
            }
        }

        System.out.println(soldier1.index + " " + soldier2.index);
        scanner.close();
    }
}

class Soldier {
    int index;
    int height;

    public int getIndex() {
        return index;
    }

    public int getHeight() {
        return height;
    }
}
