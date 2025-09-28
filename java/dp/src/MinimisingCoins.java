import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class MinimisingCoins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // first line input
        int n = sc.nextInt();  // number of coins
        int x = sc.nextInt();  // desired sum

        // second line input
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        int[] dp = new int[x + 1];
        Arrays.fill(dp, x + 1);
        dp[0] = 0;
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
//            System.out.println(i + " -> " + dp[i]);
        }

        System.out.println(dp[x] == x + 1 ? -1 : dp[x]);
    }
}
