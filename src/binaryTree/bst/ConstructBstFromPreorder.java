package src.binaryTree.bst;

import src.binaryTree.Node;

public class ConstructBstFromPreorder {
    public static void main(String[] args) {
        int[] arr = {8, 5, 1, 7, 10, 12};
        int upper_bound = Integer.MAX_VALUE;
        int[] i = {0};
        Node root = constructBst(arr, upper_bound, i);
    }

    private static Node constructBst(int[] arr, int upperBound, int[] i) {
        if (i[0] == arr.length || arr[i[0]] > upperBound)
            return null;
        Node root = new Node(arr[i[0]++]);
        root.left = constructBst(arr, root.val, i);
        root.right = constructBst(arr, upperBound, i);
        return root;
    }
}
