import com.sun.source.tree.Tree;

public class leetcode101 {
    public static void main(String[] args) {
        leetcode101 obj = new leetcode101();

        // Build tree [1,2,2,3,4,4,3]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(obj.isSymmetric(root));
    }

    boolean isMirror(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if (leftNode == null || rightNode == null) {
            return false;
        }

        return (leftNode.val == rightNode.val) && isMirror(leftNode.left, rightNode.right) && isMirror(leftNode.right, rightNode.left);
    }


    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }
}
