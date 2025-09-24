import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class boundaryTraversal {
    public static void main(String[] args) {
        boundaryTraversal obj = new boundaryTraversal();

        // Construct the tree from [1, 2, null, 4, 9, 6, 5, 3, null, null, null, null, null, 7, 8]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        // right child of 1 is null
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(9);

        // children of "null" node (skipped)

        root.left.left.left = new TreeNode(6);
        root.left.left.right = new TreeNode(5);

        root.left.right.left = new TreeNode(3);

        // children of the skipped nulls → ignored

        root.left.left.left.left = new TreeNode(7);
        root.left.left.left.right = new TreeNode(8);

        System.out.println(obj.boundary(root));
    }

    boolean isLeaf(TreeNode node) {
        if (node.left == null && node.right == null) {
            return true;
        }
        return false;
    }

    void addLeftNodes(TreeNode root, ArrayList<Integer> ans) {
        TreeNode currentNode = root.left;
        while (currentNode != null) {
            if (!isLeaf(currentNode)) {
                ans.add(currentNode.val);
            }
            if (currentNode.left != null) currentNode = currentNode.left;
            else currentNode = currentNode.right;
        }
    }

    void addLeafNodes(TreeNode root, ArrayList<Integer> ans) {
        if (isLeaf(root)) {
            ans.add(root.val);
            return;
        }

        if (root.left != null) addLeafNodes(root.left, ans);
        if (root.right != null) addLeafNodes(root.right, ans);
    }

    void addRightNodes(TreeNode root, ArrayList<Integer> ans) {
        TreeNode currentNode = root.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while (currentNode != null) {
            if (!isLeaf(currentNode)) {
                temp.add(currentNode.val);
            }
            if (currentNode.right != null) currentNode = currentNode.right;
            else currentNode = currentNode.left;
        }
        ans.addAll(temp.reversed());
    }

    public List<Integer> boundary(TreeNode root) {
        // your code stays same
        ArrayList<Integer> ans = new ArrayList<>();
        if (root != null) {
            ans.add(root.val);
        }
        addLeftNodes(root, ans);
        addLeafNodes(root, ans);
        addRightNodes(root, ans);
        return ans;
    }
}


