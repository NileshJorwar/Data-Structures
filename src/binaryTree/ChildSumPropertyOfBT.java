package src.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * At any time node's value should be left+right nodes values
 * */
public class ChildSumPropertyOfBT {

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
        childSumProperty(rootNode);
        System.out.println();
    }

    private static void childSumProperty(Node root) {
        if (root == null) {
            return;
        }
        int child = 0;
        if (root.left != null) {
            child += root.left.data;
        }
        if (root.right != null) {
            child += root.right.data;
        }
        if (child >= root.data) {
            root.data = child;
        } else {
            if (root.left != null)
                root.left.data = root.data;
            if (root.right != null)
                root.right.data = root.data;
        }
        childSumProperty(root.left);
        childSumProperty(root.right);

        int total = 0;
        if (root.left != null) {
            total += root.left.data;
        }
        if (root.right != null) {
            total += root.right.data;
        }
        if (root.left != null || root.right != null) {
            root.data = total;
        }
    }


}
