package src.binaryTree.contructtreefromtraversals;

import src.binaryTree.Node;

import java.util.*;


public class ConstructBinaryTreeFrmInorderPreorder {

    public static void main(String[] args) {
        int[] inorder = {4, 2, 7, 8, 1, 6, 9};
        int[] preOrder = {1, 2, 4, 7, 8, 9, 6};
        Node root = constructTree(inorder, preOrder);
        System.out.println(root);
    }

    private static Node constructTree(int[] inorder, int[] preOrder) {
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length - 1,
                preOrder, 0, preOrder.length - 1, inOrderMap);

    }

    private static Node buildTree(int[] inorder, int inStart, int inEnd, int[] preOrder, int preStart, int preEnd, Map<Integer, Integer> inOrderMap) {
        if (inStart > inEnd || preStart > preEnd)
            return null;

        Node root = new Node(preOrder[preStart]);

        int inRoot = inOrderMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(inorder, inStart, inRoot - 1,
                preOrder, preStart + 1, preStart + numsLeft, inOrderMap
        );

        root.right = buildTree(inorder, inRoot + 1, inEnd,
                preOrder, preStart + numsLeft + 1, preEnd, inOrderMap
        );
        return root;
    }

}
