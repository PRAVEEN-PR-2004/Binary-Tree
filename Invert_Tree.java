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

public class Invert_Tree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> store = new LinkedList<>();
        store.add(root);
        while (!store.isEmpty()) {
            TreeNode cur = store.poll();
            TreeNode tem = cur.left;
            cur.left = cur.right;
            cur.right = tem;
            if (cur.left != null) {
                store.add(cur.left);
            }
            if (cur.right != null) {
                store.add(cur.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        // Example usage:
        // Construct a binary tree:
        // 4
        // / \
        // 2 7
        // / \ / \
        // 1 3 6 9

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        // Create an instance of Invert_Tree and call invertTree
        Invert_Tree invertTreeInstance = new Invert_Tree();
        TreeNode invertedRoot = invertTreeInstance.invertTree(root);

        // Print the tree in level-order to verify inversion
        System.out.println("Inverted Tree (Level Order): ");
        printLevelOrder(invertedRoot);
    }

    // Helper method to print the tree in level-order
    public static void printLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        System.out.println();
    }
}
