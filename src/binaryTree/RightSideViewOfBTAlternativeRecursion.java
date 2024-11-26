package src.binaryTree;

import java.util.*;


public class RightSideViewOfBTAlternativeRecursion {

    static List<Integer> result = new ArrayList<>();

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

        new RightSideViewOfBTAlternativeRecursion().rightSideViewRecursive(rootNode, 0);
        System.out.println(result);
    }


    public void rightSideViewRecursive(Node node, int level) {
        if (node == null)
            return;
        if(result.size()==level){
            result.add(node.val);
        }
        rightSideViewRecursive(node.right, level+1);
        rightSideViewRecursive(node.left, level+1);
    }

}
