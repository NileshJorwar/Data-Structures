package src.binaryTree.bst;

import src.binaryTree.Node;

/*
 * Floor: greater value smaller than equal to key
 * Example: key = 7, ?>=7 , it could be 7 or 6 ?
 * */
public class FloorInBST {

    public static void main(String[] args) {
        Node rootNode = new Node(10);
        rootNode.right = new Node(13);
        rootNode.left = new Node(6);
        rootNode.left.left = new Node(4);
        rootNode.left.right = new Node(7);
        rootNode.right.right = new Node(19);
        rootNode.right.right.left = new Node(17);
        int floor = floor(rootNode, 8);
        System.out.println(floor);
    }

    private static int floor(Node root, int key) {
        int floor = -1;
        while (root != null) {
            if (root.val == key) {
                floor = root.val;
                return floor;
            }
            if (key < root.val) {
                root = root.left;
            } else {
                floor = root.val;
                root = root.right;
            }
        }
        return floor;
    }


}
