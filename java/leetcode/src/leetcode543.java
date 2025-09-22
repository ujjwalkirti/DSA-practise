public class leetcode543 {
    public static void main(String[] args) {
        leetcode543 obj = new leetcode543();

        // Example tree: root = [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(
                3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7))
        );

        // Will print result of maxDepth when implemented
        System.out.println(obj.diameterOfBinaryTree(root));
    }

    static class Diapair {
        int dia;
        int height;
    }

    public Diapair diameter2(TreeNode root) {
        if (root == null) {
            Diapair bp = new Diapair();
            bp.height = -1;
            bp.dia = 0;
            return bp;
        }
        Diapair lp = diameter2(root.left);
        Diapair rp = diameter2(root.right);

        Diapair mp = new Diapair();
        mp.height = Math.max(lp.height, rp.height) + 1;
        mp.dia = Math.max(lp.height + rp.height +2, Math.max(lp.dia,rp.dia));
        return mp;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        Diapair diameter = diameter2(root);
        return diameter.dia;
    }
}
