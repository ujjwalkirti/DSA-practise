import java.util.Arrays;
import java.util.Scanner;

public class RemoveDigits {
    static final int LIMIT2 = 1_000_000;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
//        Arrays.fill(dp,LIMIT2+1);
        for (int i = 1; i < n + 1; i++) {
            dp[i] = 1_000_000_000;
            int i2 = i;
            while (i2 > 0) {
                dp[i] = Math.min(dp[i], dp[i - i2 % 10] + 1);
                i2 /= 10;
            }
        }
        System.out.println(dp[n]);
    }
}
