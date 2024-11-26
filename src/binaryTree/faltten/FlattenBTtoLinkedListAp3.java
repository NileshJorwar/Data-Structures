package src.binaryTree.faltten;

import src.binaryTree.Node;

import java.util.Stack;

public class FlattenBTtoLinkedListAp3 {
    static Node prev = null;

    public static void main(String[] args) {
        Node rootNode = new Node(1);
        rootNode.right = new Node(5);
        rootNode.left = new Node(2);
        rootNode.left.left = new Node(3);
        rootNode.left.right = new Node(4);
        rootNode.right.right = new Node(6);
        rootNode.right.right.left = new Node(7);
        flattenTreeToLinkedList(rootNode);
        System.out.println();
    }

    public static void flattenTreeToLinkedList(Node rootNode) {
        while (rootNode != null) {
            if (rootNode.left != null) {
                prev = rootNode.left;
                while (prev.right != null) {
                    prev=prev.right;
                }
                prev.right=rootNode.right;
                rootNode.right=rootNode.left;
            }
            rootNode = rootNode.right;
        }
    }
}
