public class leetcode700 {

    public static void main(String[] args) {
        leetcode700 obj = new leetcode700();

        // Build the tree: [4,2,7,1,3]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int val = 2;
        TreeNode result = obj.searchBST(root, val);

        if (result != null) {
            System.out.println("Found node with value: " + result.val);
        } else {
            System.out.println("Value not found in BST.");
        }
    }

    // TreeNode class
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

    // Empty for now
    public TreeNode searchBST(TreeNode root, int val) {
        if (root.val == val) return root;

        if (root.val < val && root.right != null) {
            return searchBST(root.right, val);
        } else if (root.val > val && root.left != null) {
            return searchBST(root.left, val);
        }
        return null;
    }
}
