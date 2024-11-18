package src.binaryTree;

import java.util.*;


public class RootToNodePathBT {

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
        List<Integer> lists = rootToNodePathInBT(rootNode, 6);
        System.out.println(lists);
    }

    private static List<Integer> rootToNodePathInBT(Node rootNode, int value) {
        List<Integer> integerList = new ArrayList<>();
        if(rootNode == null){
            return integerList;
        }
        getRootToNodePath(rootNode, value, integerList);
        return integerList;
    }

    private static boolean getRootToNodePath(Node rootNode, int value, List<Integer> integerList) {

        if(rootNode == null){
            return false;
        }
        integerList.add(rootNode.data);
        if(rootNode.data == value){
            return true;
        }
        if(getRootToNodePath(rootNode.left, value, integerList) ||
                getRootToNodePath(rootNode.right, value, integerList)
        ){
            return true;
        }

        integerList.remove(integerList.size()-1);
        return false;
    }


}
