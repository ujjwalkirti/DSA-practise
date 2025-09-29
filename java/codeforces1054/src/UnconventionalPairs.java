import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class UnconventionalPairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UnconventionalPairs obj = new UnconventionalPairs();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            ArrayList<Integer> a = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                a.add(sc.nextInt());  // adds element at the end
            }
            System.out.println(obj.noOfPairs(n, a));
        }
    }

    int noOfPairs(int n, ArrayList<Integer> a) {
        int count = 0;
        a.sort(Comparator.naturalOrder());
        for (int i = 0; i < a.size(); i += 2) {
            int diff = a.get(i) - a.get(i + 1);
            if (diff < 0) {
                diff *= -1;
            }
            count = Math.max(count,diff);
        }
        return count;
    }
}
