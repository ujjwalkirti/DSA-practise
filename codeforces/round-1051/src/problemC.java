import java.io.*;
import java.util.*;

public class problemC {
    static final int MOD = 1_000_000_007; // only if needed for future use

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        StringBuilder sb = new StringBuilder();

        int t = fr.nextInt(); // number of test cases

        while (t-- > 0) {
            int n = fr.nextInt(); // number of vertices

            // adjacency list to store tree
            List<int[]>[] adj = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                adj[i] = new ArrayList<>();
            }

            for (int i = 0; i < n - 1; i++) {
                int u = fr.nextInt();
                int v = fr.nextInt();
                int x = fr.nextInt();
                int y = fr.nextInt();
                adj[u].add(new int[]{v, x, y});
                adj[v].add(new int[]{u, x, y});
            }

            // TODO: logic to compute the permutation
            List<Integer> permutation = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                
            }

            // output permutation
            for (int i = 0; i < n; i++) {
                
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

    // Fast input reader for large constraints
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }
}
