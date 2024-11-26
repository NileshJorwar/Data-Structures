package src.binaryTree.faltten;

import src.binaryTree.Node;

import java.util.ArrayList;
import java.util.List;

public class FlattenBTtoLinkedList {
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

        if (rootNode == null) {
            return;
        }
        flattenTreeToLinkedList(rootNode.right);
        flattenTreeToLinkedList(rootNode.left);
        rootNode.right = prev;
        rootNode.left = null;
        prev = rootNode;
    }
}
