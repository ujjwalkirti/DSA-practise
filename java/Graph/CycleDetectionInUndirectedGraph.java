import java.util.List;

class CycleDetectionInUndirectedGraph {
    public boolean isCycle(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, recStack, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isCyclicUtil(int v, boolean[] visited, boolean[] recStack, List<List<Integer>> adj) {
        visited[v] = true;
        recStack[v] = true;
        for (Integer neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                if (isCyclicUtil(neighbor, visited, recStack, adj)) {
                    return true;
                }
            } else if (recStack[neighbor]) {
                return true;
            }
        }
        recStack[v] = false;
        return false;
    }
}