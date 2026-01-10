import java.util.Arrays;
import java.util.PriorityQueue;

class Node {
    int id;
    int dist;

    Node(int id, int d) {
        this.id = id;
        this.dist = d;
    }
}

class NetworkDelayTime {
    public static void main(String[] args) {
        NetworkDelayTime obj = new NetworkDelayTime();
        int[][] times = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
        int n = 4, k = 2;
        System.out.println(obj.networkDelayTime(times, n, k));
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int ans = 0;
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>(java.util.Comparator.comparingInt(node -> node.dist));
        Node startingNode = new Node(k, 0);
        Arrays.fill(visited, false);
        pq.add(startingNode);

        while (!pq.isEmpty()) {
            Node root = pq.poll();
            if (visited[root.id]) {
                continue;
            }
            visited[root.id] = true;
            for (int[] edge : times) {
                if (edge[0] == root.id) {
                    int pathCost = root.dist + edge[2];
                    ans = Math.min(pathCost, dist[edge[1]]);
                    pq.add(new Node(edge[1], pathCost));
                }
            }
        }

        for (int i = 1; i < visited.length - 1; i++) {
            if (!visited[i]) {
                return -1;
            }
        }
        return ans;
    }

}
