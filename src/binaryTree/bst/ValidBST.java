package src.binaryTree.bst;

import src.binaryTree.Node;

//Logic is = (totalNodes - kth) is ur largest element in BST
public class ValidBST {

    public static void main(String[] args) {
        Node rootNode = new Node(5);
        rootNode.left = new Node(3);
        rootNode.right = new Node(6);
        rootNode.left.left = new Node(2);
        rootNode.left.right = new Node(4);
        rootNode.right.right = new Node(7);
        boolean is = validBst(rootNode);
        System.out.println(is);
    }

    private static boolean validBst(Node rootNode) {
        return helper(rootNode, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private static boolean helper(Node rootNode, long maxValue, long minValue) {
        if(rootNode==null) return true;
        if(rootNode.val >=maxValue || rootNode.val<=minValue){
            return false;
        }
        return helper(rootNode.left, rootNode.val, minValue) &&
         helper(rootNode.right, maxValue, rootNode.val);

    }


}
