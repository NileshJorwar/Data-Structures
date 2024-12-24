package src.binaryTree.bst;

import src.binaryTree.Node;

//Logic is = (totalNodes - kth) is ur largest element in BST
public class FindKthLargestInBST {
    static int count = 0;
    static int totalNodes = 0;
    static int result = -1;

    public static void main(String[] args) {
        Node rootNode = new Node(5);
        rootNode.left = new Node(3);
        rootNode.right = new Node(6);
        rootNode.left.left = new Node(2);
        rootNode.left.right = new Node(4);
        rootNode.right.right = new Node(7);
        countNodes(rootNode);
        usingInOrder(rootNode, 2);
        System.out.println("Total nodes: " + totalNodes);
        System.out.println(result);
    }

    private static void countNodes(Node rootNode) {
        if (rootNode == null) return;
        countNodes(rootNode.left);
        totalNodes++;
        countNodes(rootNode.right);
    }

    private static void usingInOrder(Node rootNode, int k) {
        if (rootNode == null)
            return;
        usingInOrder(rootNode.left, k);
        count++;
        if (count == (totalNodes - k) + 1) {
            result = rootNode.val;
            return;
        }
        usingInOrder(rootNode.right, k);
    }
}
