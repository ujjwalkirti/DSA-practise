import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class GraphDFS {
    public static void main(String[] args) {
        GraphDFS obj = new GraphDFS();
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        // Initialize each vertex's adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add neighbors for each vertex
        adj.get(0).add(2);
        adj.get(0).add(3);
        adj.get(0).add(1);

        adj.get(1).add(0);

        adj.get(2).add(0);
        adj.get(2).add(4);

        adj.get(3).add(0);

        adj.get(4).add(2);

        System.out.println(obj.dfsOfGraph(V, adj));
    }

    public List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                Stack<Integer> stack = new Stack<>();

                stack.push(i);

                while (!stack.isEmpty()) {
                    int vertex = stack.pop();
                    if (!visited[vertex]) {
                        ans.add(vertex);
                        visited[vertex] = true;

                        for (int j = 0; j < adj.get(vertex).size(); j++) {
                            stack.push(adj.get(vertex).get(j));

                        }
                    }
                }
            }
        }

        return ans;
    }
}