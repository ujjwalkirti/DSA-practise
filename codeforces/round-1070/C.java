import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            List<Integer> a = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                a.add(sc.nextInt());
            }
            Collections.sort(a, Collections.reverseOrder());
            for (int k = 1; k <= n; k++) {

            }
        }

        sc.close();
    }
}
