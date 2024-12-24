package src.binaryTree.bst;

import src.binaryTree.Node;

public class FindKthSmallestInBST {
    static int count = 0;
    static int result = -1;

    public static void main(String[] args) {
        Node rootNode = new Node(5);
        rootNode.left = new Node(3);
        rootNode.right = new Node(6);
        rootNode.left.left = new Node(2);
        rootNode.left.left.left = new Node(1);
        rootNode.left.right = new Node(4);

        usingInOrder(rootNode, 3);
        System.out.println(result);
    }

    private static void usingInOrder(Node rootNode, int k) {
        if (rootNode == null)
            return;
        usingInOrder(rootNode.left, k);
        count++;
        if (count == k) {
            result = rootNode.val;
            return;
        }
        usingInOrder(rootNode.right, k);
    }
}
