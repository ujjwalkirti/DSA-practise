public class leetcode543 {
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
}
