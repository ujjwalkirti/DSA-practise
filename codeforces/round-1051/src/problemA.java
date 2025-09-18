import java.util.*;

public class problemA {
    public static void main(String[] args) {
        problemA obj = new problemA();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            ArrayList<Integer> p = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                p.add(sc.nextInt());
            }

            sb.append(obj.result(p, n)).append("\n");
        }
        sc.close();

        System.out.print(sb.toString());
    }

    public String result(ArrayList<Integer> p, int n) {
        int k = 1;
        while (k <= n) {
            int index = p.indexOf(n - k + 1);
            List<Integer> chunk = p.subList(index, index + k);
            for (int i = 0; i < chunk.size(); i++) {
                if (chunk.get(i) != n - k + 1) {
                    return "No";
                } else {
                    chunk.set(i, n - k);
                }
            }
            k++;
        }
        return "YES";
    }
}
