import java.util.*;

public class lc987 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        lc987 obj = new lc987();
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(obj.verticalTraversal(root));
    }

    class Tuple {
        TreeNode node;
        int rowCoord, colCoord;

        public Tuple(TreeNode node, int x, int y) {
            this.colCoord = y;
            this.rowCoord = x;
            this.node = node;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, List<Tuple>> map = new HashMap<>();
        Queue<Tuple> q = new LinkedList<>();
        Tuple rootTuple = new Tuple(root, 0, 0);
        q.add(rootTuple);
        while (!q.isEmpty()) {
            Tuple parent = q.poll();
            TreeNode node = parent.node;
            if (node.left != null) {
                q.add(new Tuple(node.left, parent.rowCoord + 1, parent.colCoord - 1));
            }
            if (node.right != null) {
                q.add(new Tuple(node.right, parent.rowCoord + 1, parent.colCoord + 1));
            }

            List<Tuple> list = map.getOrDefault(parent.colCoord, new ArrayList<>());
            list.add(parent);
            map.put(parent.colCoord, list);
        }
        Map<Integer, List<Tuple>> sortedMap = new TreeMap<>(map);

        for (Integer key: sortedMap.keySet()) {
            List<Tuple> list = sortedMap.get(key);

            // Sort primarily by rowCoord and then by node value if rowCoord is equal
            Collections.sort(list, (a, b) -> {
                if (a.rowCoord != b.rowCoord) {
                    return Integer.compare(a.rowCoord, b.rowCoord);
                } else {
                    return Integer.compare(a.node.val, b.node.val);
                }
            });

            // Prepare the sorted values for the answer list
            List<Integer> columnNodes = new ArrayList<>();
            for (Tuple t : list) {
                columnNodes.add(t.node.val);
            }
            ans.add(columnNodes);
        }


        return ans;
    }
}
