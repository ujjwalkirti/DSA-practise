import java.util.*;
import java.io.*;

public class problemD1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        final int MOD = 1_000_000_007;

        int t = sc.nextInt(); // number of test cases

        while (t-- > 0) {
            int n = sc.nextInt(); // length of the sequence
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt(); // sequence elements
            }

            // TODO: compute number of good subsequences
            long result = 0;


            System.out.println(result % MOD);
        }

        sc.close();
    }
}
