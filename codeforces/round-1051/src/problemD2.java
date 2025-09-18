import java.util.*;

public class problemD2 {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        problemD2 obj = new problemD2();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = sc.nextInt(); // number of test cases
        while (t-- > 0) {
            int n = sc.nextInt(); // length of sequence

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            sb.append(obj.result(a, n)).append("\n");
        }
        sc.close();

        System.out.print(sb.toString());
    }

    // Skeleton function: implement your solution logic here
    public int result(int[] a, int n) {
        int ans = 0;

        // TODO: implement logic to count good subsequences modulo MOD

        return ans % MOD;
    }
}
