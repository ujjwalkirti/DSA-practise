import java.util.LinkedList;
import java.util.Queue;

class RottenOranges {
    public static void main(String[] args) {
        RottenOranges obj = new RottenOranges();
        int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        System.out.println(obj.orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {
        int time = 0, fresh = 0;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    fresh += 1;
                }
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                }
            }
        }
        int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] rottenOrangeCoordinates = q.poll();
                for (int[] delta : directions) {
                    int dr = delta[0];
                    int dc = delta[1];
                    int row = rottenOrangeCoordinates[0] + dr;
                    int col = rottenOrangeCoordinates[1] + dc;
                    if (row < 0 || row == grid.length || col < 0 || col == grid[0].length || grid[row][col] != 1) {
                        continue;
                    }

                    grid[row][col] = 2;
                    q.add(new int[] { row, col });
                    fresh -= 1;
                }
            }
            time += 1;
        }

        if (fresh > 0) {
            return -1;
        }
        return time;
    }
}