import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode103 {
    public static void main(String[] args) {
        leetcode103 obj = new leetcode103();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(obj.zigzagLevelOrder(root));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> output = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root!= null) output.add(root);
        boolean startFromLeft = true;
        while (!output.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();

            int levelSize = output.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = output.poll();
                if(startFromLeft){
                    currentLevel.add(currentNode.val);
                }else {
                    currentLevel.addFirst(currentNode.val);
                }
                if(currentNode.left != null){
                    output.add(currentNode.left);
                }

                if(currentNode.right != null){
                    output.add(currentNode.right);
                }
            }
            ans.add(currentLevel);
            startFromLeft = !startFromLeft;
        }
        return ans;
    }
}
