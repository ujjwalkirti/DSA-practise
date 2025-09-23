import java.util.List;

public class boundaryTraversal {
    public static void main(String[] args) {
        boundaryTraversal obj = new boundaryTraversal();
        // Construct the tree from the given array [1, 2, 3, 4, 5, 6, 7, null, null, 8, 9]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);

        System.out.println(obj.boundary(root));
    }
    public List<Integer> boundary(TreeNode root) {
        //your code goes here
    }
}
}
