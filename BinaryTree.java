// Class representing a Node in a Binary Tree

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int value;
    Node left, right;

    // Constructor to create a new node with given value
    Node(int value) {
        this.value = value;
        left = right = null;
    }
}

// Class representing a Binary Tree
public class BinaryTree {
    Node root;

    // Constructor to create an empty tree
    BinaryTree() {
        root = null;
    }

    // Method to print tree nodes in Inorder traversal
    void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.value + " ");
            inorderTraversal(node.right);
        }
    }

    // Method to print tree nodes in Preorder traversal
    void preorderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    // Method to print tree nodes in Postorder traversal
    void postorderTraversal(Node node) {
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.value + " ");
        }
    }

    void Levelorder(Node node) {
        Queue<Node> store = new LinkedList<>();
        store.add(node);
        while (!store.isEmpty()) {
            Node cur = store.poll();
            System.out.print(cur.value + " ");
            if (cur.left != null) {
                store.add(cur.left);
            }
            if (cur.right != null) {
                store.add(cur.right);
            }
        }
    }
    
    // Main method to test the binary tree
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Creating nodes and forming the binary tree
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        // Testing different tree traversals
        System.out.println("Inorder Traversal:");
        tree.inorderTraversal(tree.root);

        System.out.println("\nPreorder Traversal:");
        tree.preorderTraversal(tree.root);

        System.out.println("\nPostorder Traversal:");
        tree.postorderTraversal(tree.root);
        System.out.println("\nLevelorder Traversal:");
        tree.Levelorder(tree.root);
    }
}
