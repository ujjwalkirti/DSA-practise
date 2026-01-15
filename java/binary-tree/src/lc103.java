import java.util.*;

public class lc103 {

    public static void main(String[] args) {
        lc103 obj = new lc103();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(obj.zigzagLevelOrder(root));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        boolean fromLeft = true;
        if (root != null) {
            q.add(root);
        }
        while (!q.isEmpty()) {
            List<Integer> row = new ArrayList<>();
            int rowSize = q.size();
            for (int i = 0; i < rowSize; i++) {
                TreeNode lastElement = q.poll();
                if (lastElement.left != null) {
                    q.add(lastElement.left);
                }
                if (lastElement.right != null) {
                    q.add(lastElement.right);
                }
                row.add(lastElement.val);
            }

            if (!fromLeft) {
                Collections.reverse(row);
            }
            fromLeft = !fromLeft;
            ans.add(row);
        }
        return ans;
    }
}
