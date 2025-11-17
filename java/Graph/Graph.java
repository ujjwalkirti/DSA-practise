
class Graph {

    private int V;
    private int[][] adjMatrix;

    Graph(int v) {
        V = v;
        adjMatrix = new int[V][V];
    }

    // Add a directed edge from source to destination
    void addEdge(int src, int dest) {
        adjMatrix[src][dest] = 1;
    }

    void printGraph() {
        System.out.println("Adjacency Matrix Representation:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }

    }

}
