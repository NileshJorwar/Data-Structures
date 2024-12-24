package src.binaryTree.bst;

import src.binaryTree.Node;

public class FindKthSmallestInBSTUsingMorrisTraversal {
    static int count = 0;
    static int result = -1;

    public static void main(String[] args) {
        Node rootNode = new Node(5);
        rootNode.left = new Node(3);
        rootNode.right = new Node(6);
        rootNode.left.left = new Node(2);
        rootNode.left.left.left = new Node(1);
        rootNode.left.right = new Node(4);

        usingMorrisTraversal(rootNode, 3);
        System.out.println(result);
    }

    private static void usingMorrisTraversal(Node rootNode, int k) {
        Node current = rootNode;
        while (current != null) {
            if (current.left == null) {
                count++;
                if (count == k) {
                    result = current.val;
                    return;
                }
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
                    count++;
                    if (count == k) {
                        result = current.val;
                        return;
                    }
                    current = current.right;
                }
            }
        }
    }
}
