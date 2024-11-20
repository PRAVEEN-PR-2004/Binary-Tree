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

public class Postorder {
    public static List<Integer> ans;

    public List<Integer> postorderTraversal(TreeNode root) {
        ans = new ArrayList<>();
        postorder(root);
        return ans;
    }

    public static void postorder(TreeNode root) {
        if (root == null) {
            return;
        }
        postorder(root.left); // Traverse the left subtree
        postorder(root.right); // Traverse the right subtree
        ans.add(root.val); // Visit the root
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

        // Create an instance of Postorder and call postorderTraversal
        Postorder postorderTraversalInstance = new Postorder();
        List<Integer> result = postorderTraversalInstance.postorderTraversal(root);

        // Print the result
        System.out.println("Postorder Traversal: " + result);
    }
}
