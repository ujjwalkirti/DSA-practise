import java.util.LinkedList;
import java.util.Queue;

class SurroundingRegion {
    public static void main(String[] args) {
        char[][] board = {
        { 'X', 'X', 'X', 'X' },
        { 'X', 'O', 'O', 'X' },
        { 'X', 'X', 'O', 'X' },
        { 'X', 'O', 'X', 'X' }
        };
        // char[][] board = {
        //         { 'O', 'O', 'O' },
        //         { 'O', 'O', 'O' },
        //         { 'O', 'O', 'O' }
        // };

        SurroundingRegion obj = new SurroundingRegion();
        obj.solve(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void addToRegion(char[][] board, boolean[][] visited, int[][] directions, int sr,
            int sc) {
        if (!visited[sr][sc]) {
            board[sr][sc] = 'S';
            visited[sr][sc] = true;
            for (int[] direction : directions) {
                int row = sr + direction[0];
                int col = sc + direction[1];
                // exclude null locations
                if (row < 0 || row == board.length || col < 0 || col == board[0].length) {
                    continue;
                }

                if (visited[row][col]) {
                    continue;
                }

                if (board[row][col] == 'O') {
                    addToRegion(board, visited, directions, row, col);
                }
            }
        }
    }

    public void solve(char[][] board) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && (i + 1 == board.length || i == 0 || j + 1 == board[0].length || j == 0)) {
                    q.add(new int[] { i, j });
                }
            }
        }

        int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (!q.isEmpty()) {
            int[] root = q.poll();
            addToRegion(board, visited, directions, root[0], root[1]);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'S') {
                    board[i][j] = 'O';
                }
            }
        }

    }
}