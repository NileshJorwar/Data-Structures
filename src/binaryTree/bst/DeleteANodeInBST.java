package src.binaryTree.bst;

import src.binaryTree.Node;

public class DeleteANodeInBST {
    public static void main(String[] args) {
        Node rootNode = new Node(5);
        rootNode.left = new Node(3);
        rootNode.right = new Node(6);
        rootNode.left.left = new Node(2);
        rootNode.left.right = new Node(4);
        rootNode.right.right = new Node(7);

        Node node = deleteANode(rootNode, 3);
        System.out.println(node);
    }

    private static Node deleteANode(Node root, int key) {
        if (root == null) {
            return null;
        }
        if (key == root.val) {
            return deleteHelper(root);
        }
        Node dummy = root;
        while (root != null) {
            if (root.val > key) {
                //left
                if (root.left != null && root.left.val == key) {
                    root.left = deleteHelper(root.left);
                    break;
                } else {
                    root = root.left;
                }
            }else{
                if (root.right != null && root.right.val == key) {
                    root.right = deleteHelper(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        return dummy;
    }

    private static Node deleteHelper(Node root) {
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        }
        Node rightChild = root.right;
        Node lastRightOfLeftNode = findLastRightOfLeftNode(root.left);
        lastRightOfLeftNode.right = rightChild;
        return root.left;
    }

    private static Node findLastRightOfLeftNode(Node root) {
        if (root.right == null) {
            return root;
        }
        return findLastRightOfLeftNode(root.right);
    }
}
