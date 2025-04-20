import java.util.*;

class Solution {
    public int findNumberOfComponent(int E, int V, List<List<Integer>> edges) {
        List<Integer> visitedVertex = new ArrayList<>();
        Integer component = 0;
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            if(visitedVertex.contains(u) && visitedVertex.contains(v)){
                continue;
            }
            if (visitedVertex.contains(u) && !visitedVertex.contains(v)) {
                visitedVertex.add(v);
                continue;
            }
            if(visitedVertex.contains(v) && !visitedVertex.contains(u)){
                visitedVertex.add(u);
                continue;
            }
            visitedVertex.add(u);
            visitedVertex.add(v);
            component++;
        }
        component += (V - visitedVertex.size());
        return component;
    }
}

