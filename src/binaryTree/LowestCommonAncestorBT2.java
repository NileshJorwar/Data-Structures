package src.binaryTree;

import java.util.ArrayList;
import java.util.List;


public class LowestCommonAncestorBT2 {

    public static void main(String[] args) {
        Node rootNode = new Node(1);
        rootNode.right = new Node(3);
        rootNode.left = new Node(2);
        rootNode.left.left = new Node(4);
        rootNode.left.right = new Node(10);
        rootNode.left.left.right = new Node(5);
        rootNode.left.left.right.right = new Node(6);
        rootNode.right.left = new Node(7);
        rootNode.right.right = new Node(10);
        Node result = lowestCommonAncestor(rootNode, rootNode.left.left, rootNode.left.left.right);
        System.out.println(result);
    }

    private static Node lowestCommonAncestor(Node rootNode, Node p, Node q) {

        if (rootNode == null || rootNode == p || rootNode == q) {
            return rootNode;
        }
        Node left = lowestCommonAncestor(rootNode.left, p, q);
        Node right = lowestCommonAncestor(rootNode.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return rootNode;
        }
    }


}
