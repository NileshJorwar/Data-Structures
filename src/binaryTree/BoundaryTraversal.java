package src.binaryTree;

import java.util.ArrayList;
import java.util.List;


public class BoundaryTraversal {
    public static void main(String[] args) {
        Node rootNode = new Node(1);
        rootNode.right = new Node(7);
        rootNode.left = new Node(2);
        rootNode.left.left = new Node(3);
        rootNode.left.right = new Node(4);
        rootNode.left.right.left = new Node(5);
        rootNode.left.right.right = new Node(6);
        List<Integer> ans = boundaryTraversal(rootNode);
        System.out.println(ans + ": boundary traversal");
    }

    /*
     *           1
     *       2       7
     *   3       4
     *        5      6
     * */
    public static List<Integer> boundaryTraversal(Node rootNode) {
        var list = new ArrayList<Integer>();
        if (isLeafNode(rootNode) == false)
            list.add(rootNode.val);
        addLeftBoundary(rootNode, list);
        addLeaves(rootNode, list);
        addRightBoundaryReversed(rootNode, list);
        return list;

    }

    private static void addRightBoundaryReversed(Node rootNode, ArrayList<Integer> list) {
        Node current = rootNode.right;
        var temp = new ArrayList<Integer>();
        while (current != null) {
            if (isLeafNode(current) == false)
                temp.add(current.val);
            if (current.right != null)
                current = current.right;
            else
                current = current.left;
        }
        int j = 0;
        for (j = temp.size() - 1; j >= 0; --j) {
            list.add(temp.get(j));
        }
    }

    private static void addLeaves(Node rootNode, ArrayList<Integer> list) {
        if (isLeafNode(rootNode)) {
            list.add(rootNode.val);
            return;
        }
        if (rootNode.left != null)
            addLeaves(rootNode.left, list);
        if (rootNode.right != null)
            addLeaves(rootNode.right, list);
    }

    private static void addLeftBoundary(Node rootNode, ArrayList<Integer> list) {
        Node current = rootNode.left;
        while (current != null) {
            if (isLeafNode(current) == false)
                list.add(current.val);
            if (current.left != null)
                current = current.left;
            else
                current = current.right;
        }
    }

    public static boolean isLeafNode(Node node) {
        if (node.left == null && node.right == null)
            return true;
        return false;
    }
}
