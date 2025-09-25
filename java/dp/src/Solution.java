import java.util.*;

public class Solution {
    static final int MOD = 1000000007;

    int calculateThrows(int sum, int[] recordedValues) {
        if (sum == 0) return 1;   // one valid way (no dice)
        if (sum < 0) return 0;    // invalid

        if (recordedValues[sum] != -1) return recordedValues[sum];

        long ways = 0;
        for (int dice = 1; dice <= 6; dice++) {
            ways += calculateThrows(sum - dice, recordedValues);
            ways %= MOD;
        }

        return recordedValues[sum] = (int) ways;
    }

    public int diceCombinations(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return calculateThrows(n, dp);
    }
}
