package trees;

import java.util.Scanner;

public class BinaryTree {

    //Total Nodes = 2^i

    // For height 'h' ; total number of nodes = 2^h-1
    // to calculate the index of left node when storing in array like data structure, 2*i, right node = (2*i)+1
    static Scanner scanner = null;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        Node root = createTree();

        System.out.println(" Inorder Traversal: ");
        inOrder(root);

        System.out.println(" PreOrder Traversal: ");
        preOrder(root);

        System.out.println(" PostOrder Traversal: ");
        postOrder(root);

    }

    static Node createTree() {
        Node root = null;
        System.out.println("Enter the data: ");
        int data = scanner.nextInt();

        if (data == -1)
            return null;
        root = new Node(data);

        System.out.println("Enter the left for : " + data);
        root.left = createTree();

        System.out.println("Enter the right for : " + data);
        root.right = createTree();

        return root;
    }

    static void inOrder(Node root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(" " + root.data);
        inOrder(root.right);
    }

    static void preOrder(Node root) {
        if (root == null)
            return;
        System.out.print(" " + root.data);
        preOrder(root.left);
        preOrder(root.right);
    }
    static void postOrder(Node root) {
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(" " + root.data);
    }
}

class Node {
    Node left, right;
    int data;

    public Node(int data) {
        this.data = data;
    }
}
