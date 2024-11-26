package src.binaryTree.bst;

import src.binaryTree.Node;

public class SearchInBST {
    static Node prev = null;

    public static void main(String[] args) {
        Node rootNode = new Node(10);
        rootNode.right = new Node(13);
        rootNode.left = new Node(6);
        rootNode.left.left = new Node(4);
        rootNode.left.right = new Node(7);
        rootNode.right.right = new Node(19);
        rootNode.right.right.left = new Node(17);
        Node node = search(rootNode, 6);
//        Node node = searchRecursive(rootNode, 6);
        System.out.println();
    }

    private static Node search(Node rootNode, int i) {
        while (rootNode != null && rootNode.val != i) {
            rootNode = i < rootNode.val ? rootNode.left : rootNode.right;
        }
        return rootNode;
    }

    private static Node searchRecursive(Node rootNode, int i) {
        if (rootNode == null) {
            return null;
        }
        if (rootNode.val == i) {
            return rootNode;
        }
        if (i < rootNode.val) {
            return searchRecursive(rootNode.left, i);
        } else {
            return searchRecursive(rootNode.right, i);
        }
    }


}
