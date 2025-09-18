/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class leetcode104 {
    public static void main(String[] args) {
        leetcode104 obj = new leetcode104();

        // Example tree: root = [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(
                3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7))
        );

        // Will print result of maxDepth when implemented
        System.out.println(obj.maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        // function implementation goes here
        if(root != null){
            return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
        }
        return 0;
    }
}
