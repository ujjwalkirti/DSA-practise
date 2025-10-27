import java.util.LinkedList;
import java.util.Queue;

class NumberOfEnclaves {
    public static void main(String[] args) {
        int[][] grid = { { 0, 0, 0, 0 }, { 1, 0, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 0 } };
        NumberOfEnclaves obj = new NumberOfEnclaves();
        System.out.println(obj.numEnclaves(grid));
    }

    private void traverseGrid(int[][] grid, boolean[][] visited, int sr, int sc) {
        if (!visited[sr][sc]) {
            grid[sr][sc] = 2;
            visited[sr][sc] = true;
            int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
            for (int[] direction : directions) {
                int row = sr + direction[0];
                int col = sc + direction[1];
                if (row < 0 || row == grid.length || col < 0 || col == grid[0].length) {
                    continue;
                }

                if (grid[row][col] == 1) {
                    traverseGrid(grid, visited, row, col);
                }
            }
        }
    }

    private boolean isBoundaryCell(int row, int col, int[][] grid) {
        if (row == 0 || row + 1 == grid.length || col == 0 || col + 1 == grid[0].length) {
            return true;
        }
        return false;
    }

    public int numEnclaves(int[][] grid) {
        int ans = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> landCells = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && isBoundaryCell(i, j, grid)) {
                    landCells.add(new int[] { i, j });
                }
            }
        }

        while (!landCells.isEmpty()) {
            int[] node = landCells.poll();
            traverseGrid(grid, visited, node[0], node[1]);
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }
}