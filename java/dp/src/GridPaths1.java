import java.util.Scanner;

public class GridPaths1 {
    private static final int LIMIT = 1_000_000_000 + 9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = sc.nextLine().toCharArray();
        }

        // your logic here
        int[][] dp = new int[n][n];

    }
}
