class Floodfill {
    public static void main(String[] args) {
        Floodfill obj = new Floodfill();
        // int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int[][] image = { { 0, 0, 0 }, { 0, 0, 0 }};
        int sr = 0;
        int sc = 0;
        int newColor = 0;
        int[][] ans = obj.floodFill(image, sr, sc, newColor);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                System.out.println(ans[i][j]);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        int originalColor = image[sr][sc];
        image[sr][sc] = color;
        for (int[] direction : directions) {
            int row = sr + direction[0];
            int col = sc + direction[1];
            if (row < 0 || row == image.length || col < 0 || col == image[0].length
                    || image[row][col] != originalColor || image[row][col]==color) {
                continue;
            }
            floodFill(image, row, col, color);
        }
        return image;
    }
}