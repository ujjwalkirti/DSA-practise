import java.util.Arrays;
import java.util.Scanner;

public class CoinCombinations2 {
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        // Use long just in case, though int should suffice if modulo is applied correctly.
        // It's safer to use 'int' here as the final result will be <= MOD.
        int[] dp = new int[x + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            int coin = coins[i];
            for (int j = Math.min(coin, x); j < x + 1; j++) {
                int diff = j - coin;
                if (diff>=0 && dp[diff] != 0) {
                    dp[j] = (dp[j] + dp[j - coin]) % MOD;
                }
            }
        }
        System.out.println(dp[x]);
    }
}
