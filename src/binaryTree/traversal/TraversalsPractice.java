package src.binaryTree.traversal;

import src.binaryTree.Node;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TraversalsPractice {
    public static void main(String[] args) {
        Node rootNode = new Node(1);
        rootNode.right = new Node(3);
        rootNode.left = new Node(2);
        rootNode.left.left = new Node(4);
        rootNode.left.right = new Node(10);
        rootNode.left.right.right = new Node(5);
        rootNode.left.right.right.right = new Node(6);
        rootNode.right.left = new Node(7);
        rootNode.right.right = new Node(10);
//        allTraversalsInOne(rootNode);
        getPreOrderList(rootNode);
    }

    private static List<Integer> getPreOrderList(Node rootNode){
        List<Integer> list = new ArrayList<>();
        if(rootNode==null)
            return list;
        Stack<Node> stack = new Stack<>();
        stack.push(rootNode);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            list.add(node.val);
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }

        }
        return list;
    }
//    private static void allTraversalsInOne(Node rootNode) {
//        Stack<TempPair> stack = new Stack<>();
//        stack.push(new TempPair(rootNode,1));
//        List<Integer> inOrderList = new ArrayList<>();
//        List<Integer> preOrderList = new ArrayList<>();
//        List<Integer> postOrderList = new ArrayList<>();
//        while(!stack.isEmpty()){
//            TempPair tempPair = stack.pop();
//            if(tempPair.level == 1){
//                preOrderList.add(tempPair.node.val);
//                tempPair.level++;
//                stack.push(new TempPair(node.left),level);
//            }
//        }
//    }
}
