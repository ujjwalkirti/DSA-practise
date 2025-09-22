public class leetcode110 {
    public static void main(String[] args) {
        // Build the tree: [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        leetcode110 obj = new leetcode110();
        System.out.println(obj.isBalanced(root));
    }

    public int heightOfTree(TreeNode node){
        if(node == null) return 0;
        return Math.max(heightOfTree(node.left) , heightOfTree(node.right)) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        if(!isBalanced(root.left) || !isBalanced((root.right))){
            return false;
        }
        int diff = heightOfTree(root.left) - heightOfTree(root.right);
        if(Math.abs(diff)<=1){
//            System.out.println(diff);
            return true;
        }
        return false;
    }
}