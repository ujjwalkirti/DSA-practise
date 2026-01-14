
import java.util.PriorityQueue;

public class lc1631 {
    public static void main(String[] args) {
        lc1631 obj = new lc1631();
        int[][] heights = { { 1, 2, 2 }, { 3, 8, 2 }, { 5, 3, 5 } };
        System.out.println(obj.minimumEffortPath(heights));
    }

    class Node {
        int[] coords = new int[2];
        int maxAbsoluteDif;

        Node(int x, int y, int diff) {
            this.coords = new int[] { x, y };
            this.maxAbsoluteDif = diff;
        }

    }

    public int minimumEffortPath(int[][] heights) {
        int ans = Integer.MAX_VALUE;

        boolean[][] visited = new boolean[heights.length][heights[0].length];

        /*
         * what to be stored in prriority queue?
         * {[int x, int y], int maxAbsoluteDif}
         */
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.maxAbsoluteDif, b.maxAbsoluteDif));

        pq.add(new Node(0, 0, 0));

        int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int x = currentNode.coords[0];
            int y = currentNode.coords[1];
            if (visited[x][y]) {
                continue;
            }

            visited[x][y] = true;

            if (x == heights.length - 1 && y == heights[0].length - 1) {
                ans = Math.min(ans, currentNode.maxAbsoluteDif);
            }

            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (newX < 0 || newY < 0 | newX >= heights.length || newY >= heights[0].length) {
                    continue;
                }
                int newAbsoluteDiff = Math.abs(heights[newX][newY] - heights[x][y]);
                pq.add(new Node(newX, newY, Math.max(currentNode.maxAbsoluteDif, newAbsoluteDiff)));
            }

        }
        return ans;

    }

}
