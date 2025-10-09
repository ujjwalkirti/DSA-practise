
public class lc222 {
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
        lc222 obj = new lc222();
        TreeNode root = new TreeNode(1);
        root.left  = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);

        System.out.println(obj.countNodes(root));
    }

    public int countNodes(TreeNode root) {
        if(root == null) return  0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
