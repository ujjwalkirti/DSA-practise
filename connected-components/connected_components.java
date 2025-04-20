import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class connected_components {
    public static void main(String[] args) {
        int E = 2;
        int V = 4;
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(Arrays.asList(0, 1)));
        edges.add(new ArrayList<>(Arrays.asList(1, 2)));
        Solution obj = new Solution();
        int ans = obj.findNumberOfComponent(E, V, edges);
        System.out.println("Total number of connected components:" + ans);
    }
}
