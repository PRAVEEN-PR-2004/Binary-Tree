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

public class Inorder {
    public static List<Integer> ans;

    public List<Integer> inorderTraversal(TreeNode root) {
        ans = new ArrayList<>();
        inorder(root);
        return ans;
    }

    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        ans.add(root.val);
        inorder(root.right);
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

        // Create an instance of Inorder and call inorderTraversal
        Inorder inorderTraversalInstance = new Inorder();
        List<Integer> result = inorderTraversalInstance.inorderTraversal(root);

        // Print the result
        System.out.println("Inorder Traversal: " + result);
    }
}
