class TopoLogicalSort{
    public static void main(String[] args) {
        int V = 7;
        Graph graph = new Graph(V);

        // Add edges as per the image
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(4, 3);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 6);

    }
}
