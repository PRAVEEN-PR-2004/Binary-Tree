import java.util.ArrayList;
import java.util.List;

// Definition for a binary tree node.
class TreeNode {
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

public class Preorder {
    public static List<Integer> ans;

    public List<Integer> preorderTraversal(TreeNode root) {
        ans = new ArrayList<>();
        preorder(root);
        return ans;
    }

    public static void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        ans.add(root.val); // Visit the root
        preorder(root.left); // Traverse the left subtree
        preorder(root.right); // Traverse the right subtree
    }

    public static void main(String[] args) {
        // Example usage:
        // Construct a binary tree:
        // 1
        // \
        // 2
        // /
        // 3

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        // Create an instance of Preorder and call preorderTraversal
        Preorder preorderTraversalInstance = new Preorder();
        List<Integer> result = preorderTraversalInstance.preorderTraversal(root);

        // Print the result
        System.out.println("Preorder Traversal: " + result);
    }
}
