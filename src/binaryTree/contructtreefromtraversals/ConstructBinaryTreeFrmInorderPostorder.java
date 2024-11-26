package src.binaryTree.contructtreefromtraversals;

import src.binaryTree.Node;

import java.util.HashMap;
import java.util.Map;


public class ConstructBinaryTreeFrmInorderPostorder {

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        Node root = constructTree(inorder, postorder);
        System.out.println(root);
    }

    private static Node constructTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1, inOrderMap);

    }

    private static Node buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> inOrderMap) {
        if (inStart > inEnd || postStart > postEnd)
            return null;

        Node root = new Node(postorder[postEnd]);

        int inRoot = inOrderMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(inorder, inStart, inRoot - 1,
                postorder, postStart , postStart + numsLeft-1, inOrderMap
        );

        root.right = buildTree(inorder, inRoot + 1, inEnd,
                postorder, postStart + numsLeft, postEnd-1, inOrderMap
        );
        return root;
    }

}
