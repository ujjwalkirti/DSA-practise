import java.util.*;

public class diceCombination {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(diceCombinations(n));
    }

    public static int diceCombinations(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1; // base: 1 way to form 0

        for (int i = 1; i <= n; i++) {
            long ways = 0;
            for (int dice = 1; dice <= 6; dice++) {
                if (i - dice >= 0) {
                    ways += dp[i - dice];
                }
            }
            dp[i] = (int)(ways % MOD);
        }

        return dp[n];
    }
}
