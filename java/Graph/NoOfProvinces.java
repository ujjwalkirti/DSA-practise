import java.util.ArrayList;
import java.util.Stack;

class NoOfProvinces {
    public static void main(String[] args) {
        NoOfProvinces obj = new NoOfProvinces();
        int[][] matrix = {
                { 1, 1, 0 },
                { 1, 1, 0 },
                { 0, 0, 1 }
        };
        System.out.println(obj.findCircleNum(matrix));

    }

    // public int findCircleNum(int[][] isConnected) {
    // int ans = 0;
    // int noOfVertices = isConnected.length;
    // boolean[] visitedNodes = new boolean[noOfVertices];

    // Stack<Integer> stack = new Stack<>();
    // for (int i = 0; i < noOfVertices; i++) {
    // ArrayList<Integer> members = new ArrayList<>();
    // int[] row = isConnected[i];
    // stack.push(i);
    // while (!stack.isEmpty()) {
    // int index = stack.pop();
    // if (visitedNodes[index]) {
    // continue;
    // }

    // for (int j = row.length - 1; j >= 0; j--) {
    // if (row[j] == 1) {
    // stack.push(row[j]);
    // members.add(row[j]);
    // }
    // }
    // }

    // if (members.size() > 0) {
    // ans++;
    // }
    // }
    // return ans;
    // }

    public int findCircleNum(int[][] isConnected) {
        int ans = 0;
        int noOfVertices = isConnected.length;
        boolean[] visitedNodes = new boolean[noOfVertices];

        for (int i = 0; i < noOfVertices; i++) {
            // Only start DFS if node is not visited
            if (!visitedNodes[i]) {
                Stack<Integer> stack = new Stack<>();
                stack.push(i);

                while (!stack.isEmpty()) {
                    int index = stack.pop();

                    if (visitedNodes[index]) {
                        continue;
                    }

                    // Mark as visited
                    visitedNodes[index] = true;

                    // Get the row for current node
                    int[] row = isConnected[index];

                    // Check all neighbors
                    for (int j = 0; j < row.length; j++) {
                        if (row[j] == 1 && !visitedNodes[j]) {
                            stack.push(j); // Push index, not value
                        }
                    }
                }

                // Found a new province
                ans++;
            }
        }

        return ans;
    }

}