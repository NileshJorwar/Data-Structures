package src.binaryTree.bst;

import src.binaryTree.Node;

/*
* Ceil: smaller value greater than equal to key
* Example: key = 8, 8>=?
* */
public class CeilInBST {

    public static void main(String[] args) {
        Node rootNode = new Node(10);
        rootNode.right = new Node(13);
        rootNode.left = new Node(6);
        rootNode.left.left = new Node(4);
        rootNode.left.right = new Node(7);
        rootNode.right.right = new Node(19);
        rootNode.right.right.left = new Node(17);
        int ceil = ceil(rootNode, 8);
        System.out.println(ceil);
    }

    private static int ceil(Node root, int val) {
        int ceil = -1;
        while (root != null) {
            if (root.val == val) {
                ceil = root.val;
                return ceil;
            }
            if (val < root.val) {
                ceil = root.val;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return ceil;
    }


}
