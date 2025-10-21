import java.util.*;

public class lc103 {

    public static void main(String[] args) {
        lc103 obj = new lc103();
        lc987.TreeNode root = new lc987.TreeNode(1, new lc987.TreeNode(2,new lc987.TreeNode(4),new lc987.TreeNode(5)), new lc987.TreeNode(3));
        System.out.println(obj.zigzagLevelOrder(root));
    }

    public List<List<Integer>> zigzagLevelOrder(lc987.TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<lc987.TreeNode> q = new LinkedList<>();
        boolean fromLeft = true;
        if(root!=null){
            q.add(root);
        }
        while (!q.isEmpty()) {
            List<Integer> row = new ArrayList<>();
            int rowSize = q.size();
            for (int i = 0; i < rowSize; i++) {
                lc987.TreeNode lastElement = q.poll();
                if(lastElement.left!=null) {
                    q.add(lastElement.left);
                }
                if(lastElement.right!=null){
                    q.add(lastElement.right);
                }
                row.add(lastElement.val);
            }

            if(!fromLeft){
                Collections.reverse(row);
            }
            fromLeft = !fromLeft;
            ans.add(row);
        }
        return ans;
    }
}
