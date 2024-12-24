package src.binaryTree.bst;

import src.binaryTree.Node;

public class FindInorderSuccessorInBST {
    public static void main(String[] args) {
        Node rootNode = new Node(5);
        rootNode.left = new Node(3);
        rootNode.right = new Node(6);
        rootNode.left.left = new Node(2);
        rootNode.left.right = new Node(4);
        rootNode.right.right = new Node(7);
        Node p = new Node(4);
        Node node = inorderSuccessor(rootNode, p);
        System.out.println(node);
    }

    private static Node inorderSuccessor(Node rootNode, Node p) {
        Node successor = null;
        while (rootNode != null) {
            if (p.val >= rootNode.val) {
                rootNode = rootNode.right;
            }
            else {
                successor = rootNode;
                rootNode = rootNode.left;
            }
        }
        return successor;
    }
}
