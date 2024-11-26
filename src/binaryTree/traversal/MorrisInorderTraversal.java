package src.binaryTree.traversal;

import src.binaryTree.Node;

import java.util.ArrayList;
import java.util.List;

public class MorrisInorderTraversal {
    public static void main(String[] args) {
        Node rootNode = new Node(1);
        rootNode.right = new Node(3);
        rootNode.left = new Node(2);
        rootNode.left.left = new Node(4);
        rootNode.left.right = new Node(10);
        rootNode.left.right.right = new Node(5);
        rootNode.left.right.right.right = new Node(6);
//        rootNode.right.left = new Node(7);
//        rootNode.right.right = new Node(10);
        var l = morrisTraversal(rootNode);
        System.out.println(l);
    }

    public static List<Integer> morrisTraversal(Node rootNode) {
        List<Integer> inorderList = new ArrayList<>();
        Node current = rootNode;
        while (current != null) {
            if (current.left == null) {
                inorderList.add(current.val);
                current = current.right;
            } else {
                Node prev = current.left;
                while (prev.right != null && prev.right != current) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = current;
                    current = current.left;
                } else {
                    prev.right = null;
                    inorderList.add(current.val);
                    current = current.right;
                }
            }
        }
        return inorderList;
    }
}
