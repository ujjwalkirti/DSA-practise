public class leetcode124 {
    public static void main(String[] args) {
        leetcode124 obj = new leetcode124();
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(obj.maxPathSum(root));
    }

    public int maxPathSum(TreeNode root) {
        return 0;
    }
}
