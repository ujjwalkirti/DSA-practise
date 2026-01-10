import java.util.*;

class Node {
    int id;
    double dist;

    Node(int id, double d) {
        this.id = id;
        this.dist = d;
    }
}

public class lc1514 {
    public static void main(String[] args) {
        lc1514 obj = new lc1514();
        int n = 3, start_node = 0, end = 2;
        int[][] edges = new int[][] { { 0, 1 }, { 1, 2 }, { 0, 2 } };
        double[] succProb = new double[] { 0.5, 0.5, 0.2 };
        System.out.println(obj.maxProbability(n, edges, succProb, start_node, end));
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] probabilities = new double[n];
        probabilities[start_node] = 1.0;

        // Create a graph with edge weights
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(new int[] { v, i });
            graph.get(v).add(new int[] { u, i });
        }

        // Max-heap priority queue
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Double.compare(b.dist, a.dist));
        pq.add(new Node(start_node, 1.0));

        while (!pq.isEmpty()) {
            Node root = pq.poll();
            if (root.id == end_node) {
                return root.dist;
            }

            if (root.dist < probabilities[root.id]) {
                continue;
            }

            for (int[] neighbor : graph.get(root.id)) {
                int node = neighbor[0];
                double edgeProb = succProb[neighbor[1]];
                double newProb = edgeProb * root.dist;
                if (newProb > probabilities[node]) {
                    probabilities[node] = newProb;
                    pq.add(new Node(node, newProb));
                }
            }

        }

        return 0.0;
    }
}
