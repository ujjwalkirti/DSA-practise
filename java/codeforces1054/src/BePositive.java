import java.util.HashMap;
import java.util.Scanner;

public class BePositive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BePositive obj = new BePositive();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = sc.nextInt();
            }
            System.out.println(obj.minSwaps(n, a));
        }
    }

    int minSwaps(int n, int[] a) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        int negCount = map.getOrDefault(-1, 0);
        int zeroCount = map.getOrDefault(0, 0);

        if (negCount % 2 == 1) {
            count += 2;
        }
        if (zeroCount > 0) {
            count += zeroCount;
        }

        return count;
    }
}
