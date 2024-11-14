import java.util.LinkedList;
import java.util.Queue;

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        val = data;
        left = right = null;
    }

}

public class Max_Height_Tree {

    public int levelorder(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> store = new LinkedList<>();
        store.add(root);
        int count = 0;

        while (!store.isEmpty()) {
            int treeHeight = store.size();

            for (int i = 0; i < treeHeight; i++) {
                TreeNode cur = store.poll();
                System.out.print(cur.val + " "); // Print current node value

                if (cur.left != null) {
                    store.add(cur.left);
                }

                if (cur.right != null) {
                    store.add(cur.right);
                }
            }
            System.out.println(); // Move to the next line after each level
            count++;
        }
        return count;
    }

    public int maxDepth(TreeNode root) {
        return levelorder(root);
    }

    // Main method to test the maxDepth function
    public static void main(String[] args) {
        Max_Height_Tree solution = new Max_Height_Tree();

        // Creating a sample tree:
        // 1
        // / \
        // 2 3
        // / \ / \
        // 4 5 6 7
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("Level order traversal:");
        int height = solution.maxDepth(root);
        System.out.println("Height of the tree: " + height);
    }
}
