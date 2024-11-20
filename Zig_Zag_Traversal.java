import java.util.*;

public class Zig_Zag_Traversal {

    // Definition for a binary tree node.
    public static class TreeNode {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> store = new LinkedList<>();
        store.add(root);
        boolean leftToRight = true;

        while (!store.isEmpty()) {
            List<Integer> curstore = new ArrayList<>();
            int groupsize = store.size();

            for (int i = 0; i < groupsize; i++) {
                TreeNode curNode = store.poll();
                if (leftToRight) {
                    curstore.add(curNode.val);
                } else {
                    curstore.add(0, curNode.val); // Reverses order for this level
                }
                if (curNode.left != null) {
                    store.add(curNode.left);
                }
                if (curNode.right != null) {
                    store.add(curNode.right);
                }
            }

            ans.add(curstore);
            leftToRight = !leftToRight; // Toggle direction
        }
        return ans;
    }

    public static void main(String[] args) {
        Zig_Zag_Traversal solution = new Zig_Zag_Traversal();

        // Create sample binary tree:
        // 1
        // / \
        // 2 3
        // / \ \
        // 4 5 6
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        // Get zigzag level order traversal
        List<List<Integer>> result = solution.zigzagLevelOrder(root);

        // Print the result
        System.out.println(result);
    }
}
