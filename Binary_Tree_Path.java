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

public class Binary_Tree_Path {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        dfs(root, "", paths);
        return paths;
    }

    public static void dfs(TreeNode root, String path, List<String> paths) {
        path = path + root.val;
        if (root.left == null && root.right == null) {
            paths.add(path);
            return;
        }
        if (root.left != null) {
            dfs(root.left, path + "->", paths);
        }
        if (root.right != null) {
            dfs(root.right, path + "->", paths);
        }
    }

    public static void main(String[] args) {
        // Example tree:
        //     1
        //    / \
        //   2   3
        //    \
        //     5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        Binary_Tree_Path solution = new Binary_Tree_Path();
        List<String> result = solution.binaryTreePaths(root);

        System.out.println("Binary Tree Paths: " + result);
    }
}
