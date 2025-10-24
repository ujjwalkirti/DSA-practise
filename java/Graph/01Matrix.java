import java.util.*;

class ZeroOneMatrix {
    public static void main(String[] args) {
        int[][] mat = {
                { 0, 1, 0, 1, 1 },
                { 1, 1, 0, 0, 1 },
                { 0, 0, 0, 1, 0 },
                { 1, 0, 1, 1, 1 },
                { 1, 0, 0, 0, 1 }
        };

        // Print each element in the matrix result
        int[][] ans = updateMatrix(mat);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return new int[0][0];
        }

        int rows = mat.length;
        int cols = mat[0].length;
        int[][] ans = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>();

        // Enqueue all zeros with distance 0 and mark visited
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[] { i, j });
                    visited[i][j] = true;
                    ans[i][j] = 0;
                }
            }
        }

        int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        // BFS propagation to all directions
        while (!q.isEmpty()) {
            int[] coord = q.poll();
            int x = coord[0];
            int y = coord[1];

            for (int[] dir : directions) {
                int row = x + dir[0];
                int col = y + dir[1];

                if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row][col]) {
                    visited[row][col] = true;
                    ans[row][col] = ans[x][y] + 1;
                    q.offer(new int[] { row, col });
                }
            }
        }

        return ans;
    }
}
