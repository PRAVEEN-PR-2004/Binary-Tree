import java.util.LinkedList;
import java.util.Queue;

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

public class Min_Height_Tree {

    public int levelorder(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> store = new LinkedList<>();
        store.add(root);
        int count = 1; // Initialize count to 1 for the root level

        while (!store.isEmpty()) {
            int curval = store.size();

            for (int i = 0; i < curval; i++) {
                TreeNode cur = store.poll();

                // Check if the current node is a leaf
                if (cur.left == null && cur.right == null) {
                    return count; // Return the current depth if a leaf is found
                }

                if (cur.left != null)
                    store.add(cur.left);
                if (cur.right != null)
                    store.add(cur.right);
            }
            count++; // Increment depth after processing the current level
        }

        return count;
    }

    public int minDepth(TreeNode root) {
        return levelorder(root);
    }

    public static void main(String[] args) {
        Min_Height_Tree solution = new Min_Height_Tree();

        // Creating a sample binary tree:
        // 1
        // / \
        // 2 3
        // /
        // 4
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        // Calculate the minimum depth
        int minDepth = solution.minDepth(root);
        System.out.println("Minimum Depth of the Tree: " + minDepth);
    }
}
