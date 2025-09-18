import java.util.*;

public class problemB {
    public static void main(String[] args) {
        problemB obj = new problemB();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = sc.nextInt(); // number of test cases
        while (t-- > 0) {
            int n = sc.nextInt(); // number of products
            int k = sc.nextInt(); // number of vouchers

            ArrayList<Long> a = new ArrayList<>(); // product prices
            for (int i = 0; i < n; i++) {
                a.add(sc.nextLong());
            }

            ArrayList<Integer> b = new ArrayList<>(); // voucher values
            for (int i = 0; i < k; i++) {
                b.add(sc.nextInt());
            }

            sb.append(obj.result(a, b, n, k)).append("\n");
        }
        sc.close();

        System.out.print(sb.toString());
    }

    // skeleton function where you'll implement the logic
    public long result(ArrayList<Long> a, ArrayList<Integer> b, int n, int k) {
        long ans = 0L;
        Collections.sort(a);
        Collections.sort(b);
        if (k == 1) {
            if (n != 1) {
                int take = b.get(0); // smallest voucher after sorting
                for (int i = a.size() - 1; i > a.size() - take; i--) {
                    ans += a.get(i);
                }
                for (int i = 0; i < k; i++) {
                    ans += a.get(i);
                }
            }
        } else {
            for (int i = 0; i < b.size(); i++) {
                if (b.get(i) == 1) {
                    a.set(n - 1, 0L);
                    n--;
                } else {
                    if (n >= b.get(i)) {
                        a.set(n - b.get(i), 0L);
                        n -= b.get(i);
                    } else {
                        break;
                    }
                }
            }
            for (int i = 0; i < a.size(); i++) {
                ans += a.get(i);
            }
        }

        return ans;
    }
}
