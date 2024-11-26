package src.binaryTree;

import java.util.ArrayList;
import java.util.List;


public class LowestCommonAncestorBT {

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
        int lcs = lowestCommonAncestor(rootNode, 6);
        System.out.println(lcs);
    }

    private static int lowestCommonAncestor(Node rootNode, int value) {
        List<Integer> firstNodePathList = new ArrayList<>();
        List<Integer> secondNodePathList = new ArrayList<>();
        getRootToNodePath(rootNode, 4, firstNodePathList);
        getRootToNodePath(rootNode, 10, secondNodePathList);
        System.out.println(firstNodePathList);
        System.out.println(secondNodePathList);
        int res = 0;
        for (int i = 0; i < secondNodePathList.size(); i++) {
            if(firstNodePathList.contains(secondNodePathList.get(i))){
                res = firstNodePathList.get(i);
            }
        }
        return res ;
    }

    private static boolean getRootToNodePath(Node rootNode, int value, List<Integer> integerList) {

        if (rootNode == null) {
            return false;
        }
        integerList.add(rootNode.val);
        if (rootNode.val == value) {
            return true;
        }
        if (getRootToNodePath(rootNode.left, value, integerList) ||
                getRootToNodePath(rootNode.right, value, integerList)) {
            return true;
        }
        integerList.remove(integerList.size() - 1);
        return false;

    }


}
